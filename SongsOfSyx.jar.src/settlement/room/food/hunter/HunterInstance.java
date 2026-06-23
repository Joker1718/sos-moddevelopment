/*     */ package settlement.room.food.hunter;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ final class HunterInstance
/*     */   extends RoomInstance
/*     */   implements ROOM_PRODUCER_INSTANCE
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final ArrayCooShort coos;
/*     */   private long[] pData;
/*  28 */   private short industry = 0;
/*     */   
/*     */   double dSkill;
/*     */   int iSkill;
/*  32 */   private float skill = 1.0F;
/*     */   float produce;
/*     */   
/*     */   HunterInstance(ROOM_HUNTER blue, TmpArea area, RoomInit init) {
/*  36 */     super(blue, area, init);
/*  37 */     this.pData = industry().makeData();
/*     */     
/*  39 */     int am = 0;
/*     */     
/*  41 */     for (COORDINATE c : body()) {
/*  42 */       if (is(c) && blue.tile.init(c.x(), c.y(), this) != null) {
/*  43 */         am++;
/*     */       }
/*     */     } 
/*     */     
/*  47 */     this.coos = new ArrayCooShort(am);
/*  48 */     am = 0;
/*  49 */     for (COORDINATE c : body()) {
/*  50 */       if (is(c) && blue.tile.init(c.x(), c.y(), this) != null) {
/*  51 */         this.coos.set(am++).set(c);
/*     */       }
/*     */     } 
/*  54 */     employees().maxSet(am);
/*  55 */     employees().neededSet(am);
/*  56 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  62 */     super.loadFix();
/*  63 */     this.industry = (short)(this.industry % (blueprintI()).indus.size());
/*  64 */     this.pData = industry().makeDataFix(this.pData);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  69 */     it.lit();
/*  70 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
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
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  88 */     industry().updateRoom((ROOM_IDATA_INSTANCE)this);
/*     */     
/*  90 */     if (!(SETT.PATH()).finders.entryPoints.anyHas(mX(), mY())) {
/*     */       return;
/*     */     }
/*  93 */     if (this.iSkill > 0) {
/*  94 */       this.skill = (float)(this.dSkill / this.iSkill);
/*  95 */       this.dSkill = 0.0D;
/*  96 */       this.iSkill = 0;
/*     */     } 
/*     */     
/*  99 */     this.produce = (float)(this.produce + TIME.secondsPerDayI() * updateInterval * employees().employed() * this.skill);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_HUNTER blueprintI() {
/* 110 */     return (ROOM_HUNTER)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/* 115 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 120 */     return this.pData;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 126 */     return this.industry;
/*     */   }
/*     */ 
/*     */   
/*     */   public Industry industry() {
/* 131 */     return (Industry)(blueprintI()).indus.get(this.industry);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIndustry(int i) {
/* 137 */     if (i == this.industry) {
/*     */       return;
/*     */     }
/* 140 */     Industry in = (Industry)blueprintI().industries().get(i);
/* 141 */     if (in == null)
/*     */       return; 
/* 143 */     this.pData = in.makeData();
/* 144 */     this.industry = (byte)i;
/* 145 */     this.iSkill = 0;
/* 146 */     this.dSkill = 0.0D;
/* 147 */     this.skill = 0.0F;
/* 148 */     this.produce = 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 154 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\hunter\HunterInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */