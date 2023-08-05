.model small
.data
temp1 db 0
mensaje7 db 10, 13, "EjemploDeSuma", "$"
mensaje8 db 10, 13, "a_Igual", "$"
mensaje10 db 10, 13, "b_igual", "$"
mensaje12 db 10, 13, "s_igual_a_mas_b", "$"
temp2 db 0
mensaje17 db 10, 13, "EjemploDeResta", "$"
mensaje18 db 10, 13, "a_Igual", "$"
mensaje20 db 10, 13, "b_igua", "$"
mensaje22 db 10, 13, "r_IGUal_a_menos_b", "$"
a db 10
b db 5
s db 0
r db 0
salto db 10,13, "$"
.code
mov ax,@data
mov ds,ax 
mov al, 10
mov ah, 0 
mov a ,al 
mov al, 5
mov ah, 0 
mov b ,al 
mov al,a
mov bl,b
add al, bl 
mov temp1, al 
mov al, temp1
mov ah, 0 
mov s ,al 
mov dx,OFFSET mensaje7 
mov ah,09 
int 21h 
mov dx,OFFSET mensaje8 
mov ah,09 
int 21h 
mov dx,OFFSET salto 
mov ah,09 
int 21h 
;mov ax,0
mov al,a
aaa
mov bl,al
mov al,ah
aam 
mov bh,ah
add bh,30h
mov dl,bh
mov ah,02h
int 21h
mov dl,bl
add dl,30h
mov ah,02h
int 21h
mov dx,OFFSET mensaje10 
mov ah,09 
int 21h 
mov dx,OFFSET salto 
mov ah,09 
int 21h 
;mov ax,0
mov al,b
aaa
mov bl,al
mov al,ah
aam 
mov bh,ah
add bh,30h
mov dl,bh
mov ah,02h
int 21h
mov dl,bl
add dl,30h
mov ah,02h
int 21h
mov dx,OFFSET mensaje12 
mov ah,09 
int 21h 
mov dx,OFFSET salto 
mov ah,09 
int 21h 
;mov ax,0
mov al,s
aaa
mov bl,al
mov al,ah
aam 
mov bh,ah
add bh,30h
mov dl,bh
mov ah,02h
int 21h
mov dl,bl
add dl,30h
mov ah,02h
int 21h
mov al,a
mov bl,b
sub  al, bl 
mov temp2, al 
mov al, temp2
mov ah, 0 
mov r ,al 
mov dx,OFFSET mensaje17 
mov ah,09 
int 21h 
mov dx,OFFSET mensaje18 
mov ah,09 
int 21h 
mov dx,OFFSET salto 
mov ah,09 
int 21h 
;mov ax,0
mov al,a
aaa
mov bl,al
mov al,ah
aam 
mov bh,ah
add bh,30h
mov dl,bh
mov ah,02h
int 21h
mov dl,bl
add dl,30h
mov ah,02h
int 21h
mov dx,OFFSET mensaje20 
mov ah,09 
int 21h 
mov dx,OFFSET salto 
mov ah,09 
int 21h 
;mov ax,0
mov al,b
aaa
mov bl,al
mov al,ah
aam 
mov bh,ah
add bh,30h
mov dl,bh
mov ah,02h
int 21h
mov dl,bl
add dl,30h
mov ah,02h
int 21h
mov dx,OFFSET mensaje22 
mov ah,09 
int 21h 
mov dx,OFFSET salto 
mov ah,09 
int 21h 
;mov ax,0
mov al,r
aaa
mov bl,al
mov al,ah
aam 
mov bh,ah
add bh,30h
mov dl,bh
mov ah,02h
int 21h
mov dl,bl
add dl,30h
mov ah,02h
int 21h
mov ah,4ch
int 21H 
end 
