/*     */ package settlement.room.home.house;
/*     */ 
/*     */ import init.type.HGROUP;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.QueueInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class OddHome
/*     */ {
/*  16 */   private final QueueInteger[] queues = new QueueInteger[HGROUP.all().size()];
/*     */ 
/*     */   
/*     */   final SAVABLE saver;
/*     */ 
/*     */ 
/*     */   
/*     */   OddHome() {
/*  24 */     this.saver = new SAVABLE() {
/*     */         public void save(FilePutter file) { byte b;
/*     */           int i;
/*     */           QueueInteger[] arrayOfQueueInteger;
/*  28 */           for (i = (arrayOfQueueInteger = OddHome.this.queues).length, b = 0; b < i; ) { QueueInteger q = arrayOfQueueInteger[b];
/*  29 */             q.save(file);
/*     */             b++; }
/*     */            } public void load(FileGetter file) throws IOException { byte b;
/*     */           int i;
/*     */           QueueInteger[] arrayOfQueueInteger;
/*  34 */           for (i = (arrayOfQueueInteger = OddHome.this.queues).length, b = 0; b < i; ) { QueueInteger q = arrayOfQueueInteger[b];
/*  35 */             q.load(file);
/*     */             b++; }
/*     */            }
/*     */         public void clear() { byte b;
/*     */           int i;
/*     */           QueueInteger[] arrayOfQueueInteger;
/*  41 */           for (i = (arrayOfQueueInteger = OddHome.this.queues).length, b = 0; b < i; ) { QueueInteger q = arrayOfQueueInteger[b];
/*  42 */             q.clear();
/*     */             b++; }
/*     */            }
/*     */       };
/*     */     for (int y = 0; y < this.queues.length; y++)
/*     */       this.queues[y] = new QueueInteger(256);  } void update(int tx, int ty) {
/*  48 */     HomeInstance h = test(tx, ty, this);
/*  49 */     if (h == null)
/*     */       return; 
/*  51 */     HGROUP.HTypeBits s = h.availability();
/*  52 */     for (int ti = 0; ti < HGROUP.all().size(); ti++) {
/*  53 */       if (s.is(ti)) {
/*  54 */         HGROUP t = (HGROUP)HGROUP.all().get(ti);
/*  55 */         QueueInteger i = this.queues[t.index()];
/*  56 */         if (!i.hasRoom())
/*  57 */           i.poll(); 
/*  58 */         i.push(tx + ty * SETT.TWIDTH);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public HomeInstance get(Humanoid h, Object user) {
/*  65 */     HGROUP t = HGROUP.get(h);
/*  66 */     while (this.queues[t.index()].hasNext()) {
/*  67 */       int i = this.queues[t.index()].peek();
/*  68 */       int tx = i % SETT.TWIDTH;
/*  69 */       int ty = i / SETT.TWIDTH;
/*     */       
/*  71 */       HomeInstance ho = test(tx, ty, user);
/*  72 */       if (ho != null && ho.availability() != null && ho.availability().is(h)) {
/*  73 */         return ho;
/*     */       }
/*  75 */       this.queues[t.index()].poll();
/*     */     } 
/*     */     
/*  78 */     return null;
/*     */   }
/*     */   
/*     */   public boolean has(Humanoid h) {
/*  82 */     HGROUP t = HGROUP.get(h);
/*  83 */     while (this.queues[t.index()].hasNext()) {
/*  84 */       int i = this.queues[t.index()].peek();
/*  85 */       int tx = i % SETT.TWIDTH;
/*  86 */       int ty = i / SETT.TWIDTH;
/*     */       
/*  88 */       HomeInstance ho = test(tx, ty, this);
/*  89 */       if (ho != null) {
/*  90 */         return true;
/*     */       }
/*  92 */       this.queues[t.index()].poll();
/*     */     } 
/*  94 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private HomeInstance test(int tx, int ty, Object user) {
/*  99 */     if (!(SETT.PATH()).connectivity.is(tx, ty)) {
/* 100 */       return null;
/*     */     }
/* 102 */     HomeInstance h = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(tx, ty);
/* 103 */     if (h != null && h.serviceX() == tx && h.serviceY() == ty && h.occupants() < h.occupantsMax()) {
/* 104 */       return h;
/*     */     }
/*     */     
/* 107 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\OddHome.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */