/*     */ package settlement.room.military.training.barracks;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ final class BarracksThing
/*     */   implements SETT_JOB {
/*  17 */   private final Coo coo = new Coo();
/*  18 */   final Coo cooMan = new Coo();
/*     */   
/*     */   private int data;
/*     */   private int dataManikin;
/*     */   private final ROOM_BARRACKS b;
/*     */   private BarracksInstance ins;
/*  24 */   static final Bit reserved = new Bit(1);
/*  25 */   static final Bit used = new Bit(2);
/*     */ 
/*     */   
/*     */   BarracksThing(ROOM_BARRACKS b) {
/*  29 */     this.b = b;
/*     */   }
/*     */ 
/*     */   
/*     */   private void save() {
/*  34 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.cooMan, this.dataManikin);
/*  35 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   BarracksThing init(int tx, int ty) {
/*  41 */     this.coo.set(tx, ty);
/*  42 */     if ((SETT.ROOMS()).fData.tile.is((COORDINATE)this.coo, this.b.constructor.work)) {
/*  43 */       this.ins = (BarracksInstance)this.b.get(this.coo.x(), this.coo.y());
/*  44 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*  45 */         DIR d = (DIR)DIR.ORTHO.get(di);
/*  46 */         if (this.ins.is(tx, ty, d) && (SETT.ROOMS()).fData.tile.is((COORDINATE)this.coo, d, this.b.constructor.manikin)) {
/*  47 */           this.ins = (BarracksInstance)this.b.get(this.coo.x(), this.coo.y());
/*  48 */           this.cooMan.set((COORDINATE)this.coo);
/*  49 */           this.cooMan.increment(d.x(), d.y());
/*  50 */           this.data = (SETT.ROOMS()).data.get((COORDINATE)this.coo);
/*  51 */           this.dataManikin = (SETT.ROOMS()).data.get((COORDINATE)this.cooMan);
/*  52 */           return this;
/*     */         } 
/*     */       } 
/*  55 */       throw new RuntimeException();
/*     */     } 
/*  57 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/*  63 */     this.data = reserved.set(this.data);
/*  64 */     save();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/*  70 */     return reserved.is(this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/*  75 */     this.data = reserved.clear(this.data);
/*  76 */     this.dataManikin = used.clear(this.dataManikin);
/*  77 */     save();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/*  83 */     return !jobReservedIs(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/*  88 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid a) {
/*  93 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {
/*  98 */     this.dataManikin = used.set(this.dataManikin);
/*  99 */     save();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 105 */     jobReserveCancel(r);
/* 106 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 111 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 116 */     return (this.ins.blueprintI().employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 121 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 126 */     return this.ins.blueprintI().employment().sound();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\training\barracks\BarracksThing.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */