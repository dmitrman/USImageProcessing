function [A]=getMedianFiltered(path)
% ��������������� ���������
A=imread(path);
A=rgb2gray(A);
A=ordfilt2(A, 5, ones(3, 3)); % ��������� ����������
end