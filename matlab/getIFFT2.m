function [Y]=getiFFT(Af)
initAf=Af;
Af(1,1)=0;
Af=abs(fftshift(Af));
Af=(Af./(max(max(Af))))*255;
% ���������� �� ������� �������
% �������� �������������� �����
Y = uint8(ifft2(initAf.*(Af<0.5)));
end