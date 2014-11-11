function [R]=getStatisticFeatures(image, mask)
%% Статистические признаки в окне
A=image;
A=rgb2gray(A);
s=size(A);
w=s(2);
h=s(1);
X=[];
for i=1:mask:h-mask       
   for j=1:mask:w-mask  
		%% Формирование сигнала
		m=double(A(i:i+mask-1,j:j+mask-1));
		a=reshape(m,1,mask*mask);	
		m1=mean(a);
		m2=var(a);
		cko=sqrt(m2);
		ske=moment(a,3)/(cko^3);
		kur=moment(a,4)/(cko^4);	
		X=[X;m1 cko ske kur];			
	end
end
R=X;
end