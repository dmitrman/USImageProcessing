function [R]=getDFTFeatures(image,mask)
A=image;
s=size(A);
w=s(2);
h=s(1);
X=[];
for i=1:mask:h-mask       
   for j=1:mask:w-mask  
		%% Формирование сигнала
		m=double(A(i:i+mask-1,j:j+mask-1));
		a=reshape(m,1,mask*mask);	
		L=a;
		s1=size(L);
		w1=s1(2);
		h1=s1(1);
		Signal=reshape(L,1,w1*h1);
		Fd=128;% Частота дискретизации (Гц)
		FftL=1024;% Количество линий Фурье спектра
		% Спектральное представление сигнала
		FftS=abs(fft(Signal,FftL));% Амплитуды преобразования Фурье сигнала
		FftS=2*FftS./FftL;% Нормировка спектра по амплитуде
		FftS(1)=FftS(1)/2;% Нормировка постоянной составляющей в спектре
		F=0:Fd/FftL:Fd/2-1/FftL;% Массив частот вычисляемого спектра Фурье
		%figure% Создаем новое окно
		%plot(F,FftS(1:length(F)));% Построение спектра Фурье сигнала
		%title('Спектр сигнала');% Подпись графика
		%xlabel('Частота');% Подпись оси х графика
		%ylabel('Амплитуда');% Подпись оси у графика		
		X=[X;var(FftS(1:10))];
		%X=[X; sqrt(FftS(1)^2+FftS(5)^2+FftS(10)^2)];	
	end
end
R=X;
end