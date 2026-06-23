/*     */ package settlement.room.military.training.archery;
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
/*     */ 
/*     */ final class ArcheryThing
/*     */   implements SETT_JOB {
/*  16 */   private final Coo coo = new Coo();
/*     */   
/*     */   private int data;
/*     */   private final ROOM_ARCHERY b;
/*     */   private ArcheryInstance ins;
/*  21 */   static final Bit reserved = new Bit(1);
/*  22 */   static final Bit used = new Bit(2);
/*     */ 
/*     */   
/*     */   ArcheryThing(ROOM_ARCHERY b) {
/*  26 */     this.b = b;
/*     */   }
/*     */   
/*     */   private void save() {
/*  30 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*     */   }
/*     */   
/*     */   ArcheryThing init(int tx, int ty) {
/*  34 */     this.coo.set(tx, ty);
/*  35 */     if ((SETT.ROOMS()).fData.tile.is((COORDINATE)this.coo, this.b.constructor.plat)) {
/*  36 */       this.ins = (ArcheryInstance)this.b.get(this.coo.x(), this.coo.y());
/*  37 */       this.data = (SETT.ROOMS()).data.get((COORDINATE)this.coo);
/*  38 */       return this;
/*     */     } 
/*  40 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/*  48 */     this.data = reserved.set(this.data);
/*  49 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/*  54 */     return reserved.is(this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/*  59 */     this.data = reserved.clear(this.data);
/*  60 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/*  65 */     return !jobReservedIs(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/*  70 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid a) {
/*  75 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/*  86 */     jobReserveCancel(r);
/*  87 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/*  92 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/*  97 */     return (this.ins.blueprintI().employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 107 */     return this.ins.blueprintI().employment().sound();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\training\archery\ArcheryThing.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */