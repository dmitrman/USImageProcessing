function [Af]=getFFT2(path)
% ��������������� ���������
A=imread(path);
A=rgb2gray(A);
A=medfilt2(A,[3 3]);
%% ��������� �������������� �����
Af=fft2(A);
end