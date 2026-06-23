/*     */ package settlement.room.health.asylum;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_ASYLUM
/*     */   extends RoomBlueprintIns<AsylumInstance> implements INDUSTRY_HASER {
/*     */   final Constructor constructor;
/*     */   private int prisonersCurrent;
/*     */   private int prisonersMax;
/*     */   final Industry consumtion;
/*     */   final LIST<Industry> indus;
/*     */   
/*     */   public ROOM_ASYLUM(RoomInitData init, RoomCategorySub block) throws IOException {
/*  37 */     super(0, init, "_ASYLUM", block);
/*     */     
/*  39 */     this.constructor = new Constructor(this, init);
/*  40 */     this.consumtion = new Industry((RoomBlueprintImp)this, init.data(), null);
/*     */ 
/*     */     
/*  43 */     this.indus = (LIST<Industry>)new ArrayList(this.consumtion);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int prisoners() {
/*  53 */     return this.prisonersCurrent;
/*     */   }
/*     */   
/*     */   public int prisonersMax() {
/*  57 */     return this.prisonersMax;
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/*  62 */     return this.constructor;
/*     */   }
/*     */   
/*     */   void incPrisoners(int p, int total) {
/*  66 */     this.prisonersCurrent += p;
/*  67 */     this.prisonersMax += total;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter f) {
/*  73 */     f.i(this.prisonersCurrent);
/*  74 */     f.i(this.prisonersMax);
/*  75 */     IndustryUtil.save(f, this.indus);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter f) throws IOException {
/*  80 */     this.prisonersCurrent = f.i();
/*  81 */     this.prisonersMax = f.i();
/*     */     
/*  83 */     this.prisonersCurrent = 0;
/*  84 */     for (AsylumInstance i : all())
/*  85 */       this.prisonersCurrent += i.prisoners(); 
/*  86 */     IndustryUtil.load(f, this.indus);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/*  91 */     this.prisonersCurrent = 0;
/*  92 */     this.prisonersMax = 0;
/*  93 */     IndustryUtil.clear(this.indus);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  99 */     return null;
/*     */   }
/*     */   
/*     */   public COORDINATE registerPrisoner(Humanoid h) {
/* 103 */     if (this.prisonersCurrent >= this.prisonersMax)
/* 104 */       return null; 
/* 105 */     if (is(h.tc())) {
/* 106 */       AsylumInstance ins = (AsylumInstance)get(h.tc().x(), h.tc().y());
/* 107 */       if (ins.active() && ins.prisoners() < ins.prisonersMax()) {
/* 108 */         return ins.registerPrisoner(h);
/*     */       }
/*     */     } 
/*     */     
/* 112 */     int i = RND.rInt(instancesSize()); int k;
/* 113 */     for (k = 0; k < instancesSize(); k++) {
/* 114 */       AsylumInstance ins = (AsylumInstance)getInstance((k + i) % instancesSize());
/* 115 */       if (ins.active() && ins.prisoners() < ins.prisonersMax()) {
/* 116 */         return ins.registerPrisoner(h);
/*     */       }
/*     */     } 
/*     */     
/* 120 */     for (k = 0; k < instancesSize(); k++) {
/* 121 */       AsylumInstance ins = (AsylumInstance)getInstance((k + i) % instancesSize());
/* 122 */       LOG.ln("" + ins.active() + " " + ins.active() + " " + ins.prisoners());
/*     */     } 
/*     */     
/* 125 */     throw new RuntimeException("" + this.prisonersCurrent + " " + this.prisonersCurrent);
/*     */   }
/*     */   
/*     */   public void unregisterPrisoner(COORDINATE c) {
/* 129 */     if (is(c) && ((AsylumInstance)this.getter.get(c)).active()) {
/* 130 */       ((AsylumInstance)this.getter.get(c)).removePrisoner(c.x(), c.y());
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean eatFood(COORDINATE cell) {
/* 135 */     if (is(cell)) {
/* 136 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 137 */         DIR dir = (DIR)DIR.ORTHO.get(di);
/* 138 */         Food f = Food.init(cell.x() + dir.x(), cell.y() + dir.y());
/* 139 */         if (f != null && f.food() > 0) {
/* 140 */           f.consume();
/* 141 */           return true;
/*     */         } 
/*     */       } 
/*     */     }
/* 145 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isWithinCell(int nx, int ny, COORDINATE cell) {
/* 149 */     if (is(nx, ny) && is(cell.x(), cell.y())) {
/* 150 */       return this.constructor.isWithinCell(nx, ny, cell.x(), cell.y());
/*     */     }
/* 152 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isDoor(COORDINATE cell) {
/* 156 */     return (is(cell) && (SETT.ROOMS()).fData.tileData.get(cell) == 1);
/*     */   }
/*     */   
/*     */   public boolean isreserved(COORDINATE cell) {
/* 160 */     return (is(cell) && ((AsylumInstance)this.getter.get(cell)).active() && ((AsylumInstance)this.getter.get(cell)).isReserved(cell.x(), cell.y()));
/*     */   }
/*     */   
/*     */   public double treatmentFactor(COORDINATE cell) {
/* 164 */     AsylumInstance i = (AsylumInstance)get(cell.x(), cell.y());
/* 165 */     return treatmentFactor(i);
/*     */   }
/*     */   
/*     */   double treatmentFactor(AsylumInstance i) {
/* 169 */     if (i != null)
/* 170 */       return CLAMP.d(0.25D + 0.75D * (1.0D - i.getDegrade()) * i.employees().employed() / i.employees().max(), 0.0D, 1.0D); 
/* 171 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 176 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<Industry> industries() {
/* 181 */     return this.indus;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\asylum\ROOM_ASYLUM.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */