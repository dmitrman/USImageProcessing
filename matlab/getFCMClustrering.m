function [image,num1,num2,num3]=getFCMClustrering(X,mask,w,h)
% Классификатор на k-means
opts = [nan;nan;nan;0];
 [center,U,obj_fcn] = fcm(X,3,opts); 
maxU = max(U);
index1 = find(U(1,:)== maxU);
index2 = find(U(2,:)== maxU);
index3 = find(U(3,:)== maxU);
ind=1;
out=[];
for i=1:mask:h-mask
   img=[];
   for j=1:mask:w-mask
    if size(find(ind==index1),2)==1
       m=ones(mask,mask)*10;
	   m(:,:,2)=ones(mask,mask)*100;
	   m(:,:,3)=ones(mask,mask)*20;
      end	
    if size(find(ind==index2),2)==1
       m=ones(mask,mask)*245;
	   m(:,:,2)=ones(mask,mask)*27;
	   m(:,:,3)=ones(mask,mask)*245;
      end	
	if size(find(ind==index3),2)==1
       m=ones(mask,mask)*245;
	   m(:,:,2)=ones(mask,mask)*241;
	   m(:,:,3)=ones(mask,mask)*27;
      end	
 
	 img=[img m];
	 ind=ind+1;
   end
out=[out;img];
end
image=out;
num1=size(index1,2);
num2=size(index2,2);
num3=size(index3,2);
end