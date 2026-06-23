/*     */ package settlement.room.law.stockade;
/*     */ 
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.law.PUNISHMENT_SERVICE;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_STOCKADE
/*     */   extends RoomBlueprintIns<StockInstance> implements PUNISHMENT_SERVICE {
/*     */   final Constructor constructor;
/*     */   final Industry indu;
/*     */   static final double PRISONER_PER_TILE = 0.25D;
/*     */   final Job job;
/*     */   int prisoners;
/*     */   int prisonersMax;
/*     */   
/*     */   public ROOM_STOCKADE(RoomInitData data, RoomCategorySub cat) throws IOException {
/*  35 */     super(0, data, "_STOCKADE", cat);
/*     */     
/*  37 */     this.constructor = new Constructor(this, data);
/*  38 */     this.indu = new Industry((RoomBlueprintImp)this, 
/*  39 */         RESOURCES.EDI().makeArray(), new double[RESOURCES.EDI().all().size()], 
/*  40 */         null);
/*  41 */     this.job = new Job(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  52 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*  57 */     this.indu.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*  62 */     this.indu.load(saveFile);
/*  63 */     this.prisoners = 0;
/*  64 */     this.prisonersMax = 0;
/*  65 */     for (StockInstance ins : all()) {
/*  66 */       this.prisoners += ins.prisonersCurrent;
/*  67 */       if (ins.active()) {
/*  68 */         this.prisonersMax += ins.prisonersMax;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/*  75 */     this.indu.clear();
/*  76 */     this.prisoners = 0;
/*  77 */     this.prisonersMax = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean degrades() {
/*  82 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/*  87 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/*  92 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ 
/*     */   
/*     */   public double degradeRate() {
/*  97 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public RoomInstance registerPrisoner(COORDINATE current) {
/* 101 */     if (this.prisoners >= this.prisonersMax) {
/* 102 */       return null;
/*     */     }
/*     */     
/* 105 */     StockInstance ins = (StockInstance)this.getter.get(current);
/* 106 */     if (ins != null && ins.active() && ins.prisonersCurrent < ins.prisonersMax && 
/* 107 */       (SETT.PATH()).comps.superComp.get(current) == (SETT.PATH()).comps.superComp.get(ins.mX(), ins.mY())) {
/* 108 */       ins.prisonersCurrent = (short)(ins.prisonersCurrent + 1);
/* 109 */       this.prisoners++;
/* 110 */       return ins;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     int i = RND.rInt(instancesSize());
/* 119 */     for (int k = 0; k < instancesSize(); k++) {
/* 120 */       StockInstance stockInstance = (StockInstance)getInstance((k + i) % instancesSize());
/* 121 */       if (stockInstance.active() && stockInstance.prisonersCurrent < stockInstance.prisonersMax && 
/* 122 */         (SETT.PATH()).comps.superComp.get(current) == (SETT.PATH()).comps.superComp.get(stockInstance.mX(), stockInstance.mY())) {
/* 123 */         stockInstance.prisonersCurrent = (short)(stockInstance.prisonersCurrent + 1);
/* 124 */         this.prisoners++;
/* 125 */         return stockInstance;
/*     */       } 
/*     */     } 
/*     */     
/* 129 */     LOG.ln("nopes");
/* 130 */     return null;
/*     */   }
/*     */   
/*     */   public void unregisterPrisoner(COORDINATE c) {
/* 134 */     StockInstance ins = (StockInstance)this.getter.get(c);
/* 135 */     if (ins != null && ins.active()) {
/* 136 */       ins.prisonersCurrent = (short)(ins.prisonersCurrent - 1);
/* 137 */       this.prisoners--;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void unregisterPrisoner(int tx, int ty) {
/* 142 */     StockInstance ins = (StockInstance)this.getter.get(tx, ty);
/* 143 */     if (ins != null && ins.active()) {
/* 144 */       ins.prisonersCurrent = (short)(ins.prisonersCurrent - 1);
/* 145 */       this.prisoners--;
/*     */     } 
/*     */   }
/*     */   
/*     */   public COORDINATE foodReserve(COORDINATE c) {
/* 150 */     StockInstance ins = (StockInstance)this.getter.get(c);
/* 151 */     if (ins != null) {
/*     */       
/* 153 */       int ri = RND.rInt(ins.jobs.size());
/*     */       
/* 155 */       for (int i = 0; i < ins.jobs.size(); i++) {
/* 156 */         COORDINATE coo = ins.jobs.get((ri + i) % ins.jobs.size());
/* 157 */         if (this.job.reserve(coo.x(), coo.y(), 2, true, false))
/* 158 */           return coo; 
/*     */       } 
/*     */     } 
/* 161 */     return null;
/*     */   }
/*     */   
/*     */   public void foodUse(COORDINATE c, boolean use) {
/* 165 */     this.job.reserve(c.x(), c.y(), 2, false, use);
/*     */   }
/*     */   
/*     */   public COORDINATE latrineReserve(COORDINATE c) {
/* 169 */     StockInstance ins = (StockInstance)this.getter.get(c);
/* 170 */     if (ins != null) {
/*     */       
/* 172 */       int ri = RND.rInt(ins.jobs.size());
/*     */       
/* 174 */       for (int i = 0; i < ins.jobs.size(); i++) {
/* 175 */         COORDINATE coo = ins.jobs.get((ri + i) % ins.jobs.size());
/* 176 */         if (this.job.reserve(coo.x(), coo.y(), 3, true, false))
/* 177 */           return coo; 
/*     */       } 
/*     */     } 
/* 180 */     return null;
/*     */   }
/*     */   
/*     */   public void latrineUse(COORDINATE c, boolean use) {
/* 184 */     this.job.reserve(c.x(), c.y(), 3, false, use);
/*     */   }
/*     */   
/*     */   public boolean isWithin(int nx, int ny, COORDINATE cell) {
/* 188 */     StockInstance ins = (StockInstance)this.getter.get(nx, ny);
/* 189 */     if (ins != null && ins.is(cell)) {
/* 190 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 191 */         if (!ins.is(cell, (DIR)DIR.ALL.get(di)))
/* 192 */           return false; 
/*     */       } 
/* 194 */       return true;
/*     */     } 
/* 196 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int punishTotal() {
/* 203 */     return this.prisonersMax;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int punishUsed() {
/* 209 */     return this.prisoners;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stockade\ROOM_STOCKADE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */