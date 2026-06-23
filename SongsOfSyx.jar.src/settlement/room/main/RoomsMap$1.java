/*     */ package settlement.room.main;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements SAVABLE
/*     */ {
/*     */   public void save(FilePutter file) {
/*  43 */     file.i(RoomsMap.this.rooms.length);
/*  44 */     file.is(RoomsMap.this.roomI);
/*     */     
/*  46 */     int am = 0; byte b; int i; Room[] arrayOfRoom;
/*  47 */     for (i = (arrayOfRoom = RoomsMap.this.rooms).length, b = 0; b < i; ) { Room r = arrayOfRoom[b];
/*  48 */       if (r != null && !r.singleton)
/*  49 */         am++;  b++; }
/*     */     
/*  51 */     file.i(am);
/*     */     
/*  53 */     for (i = (arrayOfRoom = RoomsMap.this.rooms).length, b = 0; b < i; ) { Room r = arrayOfRoom[b];
/*  54 */       if (r != null && !r.singleton) {
/*     */         
/*  56 */         (SETT.ROOMS()).collection.saver().save(r.blueprint(), file);
/*     */         
/*  58 */         int pos = file.getPosition();
/*  59 */         file.i(0);
/*  60 */         file.object(r);
/*  61 */         r.saveExtra(file);
/*  62 */         int le = file.getPosition() - pos - 4;
/*  63 */         file.setAtPosition(pos, le);
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  70 */     Room[] nn = new Room[file.i()];
/*  71 */     file.is(RoomsMap.this.roomI);
/*     */     
/*  73 */     for (int i = 0; i < 256; i++) {
/*  74 */       nn[i] = RoomsMap.this.rooms[i];
/*     */     }
/*  76 */     RoomsMap.this.rooms = nn;
/*     */     
/*  78 */     int am = file.i();
/*     */     int j;
/*  80 */     for (j = 0; j < am; j++) {
/*  81 */       RoomBlueprint print = (RoomBlueprint)(SETT.ROOMS()).collection.loader().load(file);
/*  82 */       int le = file.i();
/*  83 */       if (print != null) {
/*  84 */         Room r = (Room)file.object(true);
/*  85 */         if (r != null) {
/*  86 */           r.bI = (short)print.index();
/*  87 */           if (r.loadExtra(file)) {
/*  88 */             r.loadFix();
/*  89 */             RoomsMap.this.rooms[r.index()] = r;
/*     */             
/*     */             continue;
/*     */           } 
/*     */         } 
/*     */       } 
/*  95 */       file.setPosition(file.getPosition() + le);
/*     */       
/*     */       continue;
/*     */     } 
/*  99 */     for (j = 0; j < SETT.TAREA; j++) {
/* 100 */       if (RoomsMap.this.roomI[j] != 0 && RoomsMap.this.rooms[RoomsMap.this.roomI[j]] == null) {
/* 101 */         (SETT.ROOMS()).fData.clean(j);
/* 102 */         (SETT.ROOMS()).pData.set(j, 0);
/*     */       } 
/*     */     } 
/*     */     
/* 106 */     for (RoomsMap.this.lastIndex = RoomsMap.this.singletonI; RoomsMap.this.lastIndex < RoomsMap.this.roomI.length && 
/* 107 */       RoomsMap.this.roomI[RoomsMap.this.lastIndex] != 0; RoomsMap.this.lastIndex++);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 116 */     Room[] nn = new Room[1024]; int i;
/* 117 */     for (i = 0; i < RoomsMap.this.singletonI; i++) {
/* 118 */       nn[i] = RoomsMap.this.rooms[i];
/*     */     }
/* 120 */     RoomsMap.this.rooms = nn;
/* 121 */     for (i = 0; i < SETT.TAREA; i++)
/* 122 */       RoomsMap.this.roomI[i] = 0; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\RoomsMap$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */