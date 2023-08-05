.model small
.data
mensaje3 db 10, 13, "variables", "$"
a db 2
b db 5
c db 2
salto db 10,13, "$"
.code
mov ax,@data
mov ds,ax 
mov al, 2
mov ah, 0 
mov a ,al 
mov al, 5
mov ah, 0 
mov b ,al 
mov al, 2
mov ah, 0 
mov c ,al 
mov dx,OFFSET mensaje3 
mov ah,09 
int 21h 
mov dx,OFFSET salto 
mov ah,09 
int 21h 
mov dl,a 
ADD dl, 30h 
MOV AH, 02h 
INT 21h 
mov dx,OFFSET salto 
mov ah,09 
int 21h 
mov dl,b 
ADD dl, 30h 
MOV AH, 02h 
INT 21h 
mov dx,OFFSET salto 
mov ah,09 
int 21h 
mov dl,c 
ADD dl, 30h 
MOV AH, 02h 
INT 21h 
mov ah,4ch
int 21H 
end 
