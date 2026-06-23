/*     */ package settlement.room.main.employment;
/*     */ 
/*     */ import java.io.IOException;
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
/*  73 */     file.i(RoomEquip.this.targets.size());
/*  74 */     for (int i = 0; i < RoomEquip.this.targets.size(); i++) {
/*  75 */       file.i(((RoomEquip.Target)RoomEquip.this.targets.get(i)).get());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  81 */     clear();
/*  82 */     int am = file.i();
/*     */     
/*  84 */     if (am != RoomEquip.this.targets.size()) {
/*  85 */       for (int i = 0; i < am; i++) {
/*  86 */         file.i();
/*     */       }
/*  88 */       clear();
/*     */     } else {
/*  90 */       for (int i = 0; i < RoomEquip.this.targets.size(); i++) {
/*  91 */         ((RoomEquip.Target)RoomEquip.this.targets.get(i)).set(file.i());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 100 */     RoomEquip.this.total = 0;
/* 101 */     for (int i = 0; i < RoomEquip.this.targets.size(); i++) {
/* 102 */       ((RoomEquip.Target)RoomEquip.this.targets.get(i)).set(RoomEquip.this.defaultTarget);
/* 103 */       RoomEquip.this.currents[i] = 0;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\RoomEquip$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */