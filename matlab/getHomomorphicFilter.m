function [Ihmf]=getHomomorphicFilter(image, sigma)
%% Статистические признаки в окне
image=rgb2gray(image);
I = im2double(image);
I = log(1 + I);
M = 2*size(I,1) + 1;
N = 2*size(I,2) + 1;
[X, Y] = meshgrid(1:N,1:M);
centerX = ceil(N/2);
centerY = ceil(M/2);
gaussianNumerator = (X - centerX).^2 + (Y - centerY).^2;
H = exp(-gaussianNumerator./(2*sigma.^2));
H = 1 - H;
H = fftshift(H);
If = fft2(I, M, N);
Iout = real(ifft2(H.*If));
Iout = Iout(1:size(I,1),1:size(I,2));
Ihmf = exp(Iout) - 1;
Ihmf=Ihmf-min(min(Ihmf));
Ihmf=Ihmf/max(max(Ihmf));
Ihmf=Ihmf.*255;
end