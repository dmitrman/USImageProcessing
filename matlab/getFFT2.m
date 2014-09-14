function [Af]=getFFT2(path)
% Предварительная обработка
A=imread(path);
A=rgb2gray(A);
A=medfilt2(A,[3 3]);
%% Двумерное преобразование Фурье
Af=fft2(A);
end