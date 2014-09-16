function [A]=getMedianFiltered(path)
% Предварительная обработка
A=imread(path);
A=rgb2gray(A);
A=ordfilt2(A, 5, ones(3, 3)); % Медианная фильтрация
end