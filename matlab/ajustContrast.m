function A=adjustContrast(path)
A=imread(path);
A=rgb2gray(A);
A=medfilt2(A,[3 3]);
end