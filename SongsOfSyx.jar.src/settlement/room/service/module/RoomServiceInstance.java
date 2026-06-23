/*     */ package settlement.room.service.module;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ 
/*     */ public class RoomServiceInstance
/*     */   implements Serializable {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private short available;
/*  11 */   private short reserved = 0;
/*     */   
/*     */   private final short total;
/*     */   public byte currentHigh;
/*     */   public byte lastHigh;
/*     */   
/*     */   public RoomServiceInstance(int total, RoomService data) {
/*  18 */     this.total = (short)total;
/*  19 */     data.increServices(this.total, 0);
/*     */   }
/*     */   
/*     */   public void report(FSERVICE s, RoomService data, int delta) {
/*  23 */     report(s, data, delta, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void report(FSERVICE s, RoomService data, int delta, boolean load) {
/*  30 */     if (s.findableReservedCanBe()) {
/*  31 */       this.available = (short)(this.available + delta);
/*  32 */       data.increServices(0, delta);
/*  33 */       if (delta < 0) {
/*  34 */         data.finder.report((FINDABLE)s, -1);
/*     */       } else {
/*  36 */         data.finder.report((FINDABLE)s, 1);
/*     */       } 
/*  38 */     } else if (s.findableReservedIs()) {
/*  39 */       this.reserved = (short)(this.reserved + delta);
/*     */     } 
/*  41 */     if (load) {
/*  42 */       byte h = (byte)(int)((127 * (total() - available())) / total());
/*  43 */       if (h > this.currentHigh)
/*  44 */         this.currentHigh = h; 
/*  45 */       if (h > this.lastHigh) {
/*  46 */         this.lastHigh = h;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void report(FSERVICE s, RoomService data, int delta, int reservable, int reserved) {
/*  53 */     this.reserved = (short)(this.reserved + reserved * delta);
/*  54 */     this.available = (short)(this.available + reservable * delta);
/*  55 */     data.increServices(0, reservable * delta);
/*     */     
/*  57 */     if (s.findableReservedCanBe()) {
/*  58 */       if (delta < 0) {
/*  59 */         data.finder.report((FINDABLE)s, -1);
/*     */       } else {
/*  61 */         data.finder.report((FINDABLE)s, 1);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  67 */     byte h = (byte)(int)((127 * (total() - available())) / total());
/*  68 */     if (h > this.currentHigh)
/*  69 */       this.currentHigh = h; 
/*  70 */     if (h > this.lastHigh)
/*  71 */       this.lastHigh = h; 
/*     */   }
/*     */   
/*     */   public int available() {
/*  75 */     return this.available;
/*     */   }
/*     */   
/*     */   public int total() {
/*  79 */     return this.total;
/*     */   }
/*     */   
/*     */   public int reserved() {
/*  83 */     return this.reserved;
/*     */   }
/*     */   
/*     */   public double load() {
/*  87 */     return this.lastHigh / 127.0D;
/*     */   }
/*     */   
/*     */   public void updateDay() {
/*  91 */     this.lastHigh = this.currentHigh;
/*  92 */     this.currentHigh = 0;
/*     */   }
/*     */   
/*     */   public void clearLoad() {
/*  96 */     this.lastHigh = 0;
/*  97 */     this.currentHigh = 0;
/*     */   }
/*     */   
/*     */   public void dispose(RoomService data) {
/* 101 */     data.increServices(-this.total, -this.available);
/* 102 */     this.available = 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\module\RoomServiceInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */