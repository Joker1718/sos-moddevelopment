/*     */ package settlement.room.infra.janitor;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class JanitorInstance
/*     */   extends RoomInstance implements JOBMANAGER_HASER {
/*     */   private static final long serialVersionUID = 1L;
/*     */   boolean searchForJobs = true;
/*  24 */   long tableRes = 0L;
/*     */   
/*     */   boolean auto = true;
/*  27 */   BITS bits = new BITS();
/*     */   final short rx;
/*     */   final short ry;
/*     */   
/*     */   protected JanitorInstance(ROOM_JANITOR b, TmpArea area, RoomInit init) {
/*  32 */     super(b, area, init);
/*     */ 
/*     */     
/*  35 */     employees().maxSet((int)(blueprintI()).constructor.workers.get(this));
/*  36 */     employees().neededSet((int)Math.ceil((blueprintI()).constructor.workers.get(this) / 5.0D));
/*  37 */     activate();
/*  38 */     int x = 0, y = 0;
/*  39 */     for (COORDINATE c : body()) {
/*  40 */       if (is(c) && (SETT.ROOMS()).fData.tile.is(c, b.constructor.ta)) {
/*  41 */         x = c.x();
/*  42 */         y = c.y();
/*     */       } 
/*     */     } 
/*  45 */     this.rx = (short)x;
/*  46 */     this.ry = (short)y;
/*  47 */     this.bits = new BITS();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean loadExtra(FileGetter file) throws IOException {
/*  52 */     if (this.bits.fetchAms == null)
/*  53 */       this.bits.fetchAms = new Bitsmap1D(0, 5, RESOURCES.ALL().size()); 
/*  54 */     return super.loadExtra(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  59 */     if (this.bits == null || !RESOURCES.map().loader().isSame()) {
/*  60 */       this.bits = new BITS();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  65 */     if (this.bits.fetchAms == null) {
/*  66 */       this.bits.fetchAms = new Bitsmap1D(0, 5, RESOURCES.ALL().size());
/*     */     }
/*  68 */     super.loadFix();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBadMaintenanceTile(int tx, int ty) {
/*  73 */     return (tx == this.rx && ty == this.ry);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  78 */     it.lit();
/*  79 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void activateAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  95 */     this.searchForJobs = true;
/*  96 */     this.bits.update();
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 101 */     return (blueprintI()).jm.get(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 106 */     for (RESOURCE res : RESOURCES.ALL()) {
/* 107 */       if (this.bits.resAm(res) > 0) {
/* 108 */         (SETT.THINGS()).resources.create(this.rx, this.ry, res, this.bits.resAm(res));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_JANITOR blueprintI() {
/* 115 */     return (ROOM_JANITOR)blueprint();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\janitor\JanitorInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */