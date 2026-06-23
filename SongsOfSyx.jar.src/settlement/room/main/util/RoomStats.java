/*     */ package settlement.room.main.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.Room;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.QueueInteger;
/*     */ 
/*     */ public class RoomStats
/*     */   extends ROOMS.RoomResource
/*     */ {
/*  17 */   private RoomStatsList list = new RoomStatsList(256);
/*  18 */   private RoomStatsList broken = new RoomStatsList(512);
/*     */   
/*     */   public RoomStatsList finished() {
/*  21 */     return this.list;
/*     */   }
/*     */   
/*     */   public RoomStatsList broken() {
/*  25 */     return this.broken;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  30 */     this.list.save(file);
/*  31 */     this.broken.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  36 */     this.list.load(file);
/*  37 */     this.broken.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/*  42 */     this.list.clear();
/*  43 */     this.broken.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class RoomStatsList
/*     */     implements SAVABLE
/*     */   {
/*     */     private QueueInteger list;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private QueueInteger listTemp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Coo tmp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private RoomStatsList(int size) {
/*  83 */       this.tmp = new Coo(); this.list = new QueueInteger(size); this.listTemp = new QueueInteger(size);
/*     */     } public void add(int mx, int my) { if (!this.list.hasRoom())
/*     */         this.list.poll();  int ii = mx | my << 16;
/*  86 */       this.list.push(ii); } public COORDINATE poll() { if (!this.list.hasNext())
/*  87 */         return null; 
/*  88 */       int i = this.list.poll();
/*  89 */       int tx = i & 0xFFFF;
/*  90 */       int ty = i >> 16 & 0xFFFF;
/*  91 */       Room r = (SETT.ROOMS()).map.get(tx, ty);
/*  92 */       if (r != null) {
/*  93 */         this.tmp.set(tx, ty);
/*  94 */         return (COORDINATE)this.tmp;
/*     */       } 
/*  96 */       return null; }
/*     */ 
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/* 101 */       this.list.save(file); }
/*     */     public void remove(int mx, int my) { this.listTemp.clear(); while (this.list.hasNext()) {
/*     */         int i = this.list.poll(); int tx = i & 0xFFFF; int ty = i >> 16 & 0xFFFF; if (mx == tx && my == ty)
/*     */           continue;  this.listTemp.push(i);
/*     */       }  QueueInteger l = this.list; this.list = this.listTemp; this.listTemp = l; }
/* 106 */     public int amount() { return this.list.size(); } public void load(FileGetter file) throws IOException { this.list.load(file); }
/*     */ 
/*     */ 
/*     */     
/*     */     public void clear() {
/* 111 */       this.list.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void update(double ds) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\mai\\util\RoomStats.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */