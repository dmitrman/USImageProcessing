function [A]=getMedianFiltered(path)
path='C:\2.bmp';
% Предварительная обработка
A=imread(path);
A=rgb2gray(A);
s=size(A);
w=s(2);
h=s(1);
A=ordfilt2(A, 5, ones(3, 3)); % Медианная фильтрация
end