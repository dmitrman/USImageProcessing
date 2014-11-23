function [R]=getDFTFeatures(image,mask)
A=image;
s=size(A);
w=s(2);
h=s(1);
X=[];
for i=1:mask:h-mask       
   for j=1:mask:w-mask  
		%% ������������ �������
		m=double(A(i:i+mask-1,j:j+mask-1));
		a=reshape(m,1,mask*mask);	
		L=a;
		s1=size(L);
		w1=s1(2);
		h1=s1(1);
		Signal=reshape(L,1,w1*h1);
		Fd=128;% ������� ������������� (��)
		FftL=1024;% ���������� ����� ����� �������
		% ������������ ������������� �������
		FftS=abs(fft(Signal,FftL));% ��������� �������������� ����� �������
		FftS=2*FftS./FftL;% ���������� ������� �� ���������
		FftS(1)=FftS(1)/2;% ���������� ���������� ������������ � �������
		F=0:Fd/FftL:Fd/2-1/FftL;% ������ ������ ������������ ������� �����
		%figure% ������� ����� ����
		%plot(F,FftS(1:length(F)));% ���������� ������� ����� �������
		%title('������ �������');% ������� �������
		%xlabel('�������');% ������� ��� � �������
		%ylabel('���������');% ������� ��� � �������		
		X=[X;var(FftS(1:10))];
		%X=[X; sqrt(FftS(1)^2+FftS(5)^2+FftS(10)^2)];	
	end
end
R=X;
end