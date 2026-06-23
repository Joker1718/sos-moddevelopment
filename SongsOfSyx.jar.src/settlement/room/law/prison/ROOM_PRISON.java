/*     */ package settlement.room.law.prison;
/*     */ 
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.law.PUNISHMENT_SERVICE;
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
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_PRISON
/*     */   extends RoomBlueprintIns<PrisonInstance> implements PUNISHMENT_SERVICE {
/*     */   static final double WORKER_PER_PRISONER = 0.25D;
/*     */   final Constructor constructor;
/*     */   private int prisonersCurrent;
/*     */   private int prisonersMax;
/*     */   final Industry indu;
/*     */   
/*     */   public ROOM_PRISON(RoomInitData init, RoomCategorySub block) throws IOException {
/*  34 */     super(0, init, "_PRISON", block);
/*     */     
/*  36 */     this.constructor = new Constructor(this, init);
/*  37 */     this.indu = new Industry((RoomBlueprintImp)this, 
/*  38 */         RESOURCES.EDI().makeArray(), new double[RESOURCES.EDI().all().size()], null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int punishTotal() {
/*  50 */     return this.prisonersMax;
/*     */   }
/*     */ 
/*     */   
/*     */   public int punishUsed() {
/*  55 */     return this.prisonersCurrent;
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/*  60 */     return this.constructor;
/*     */   }
/*     */   
/*     */   void incPrisoners(int p, int total) {
/*  64 */     this.prisonersCurrent += p;
/*  65 */     this.prisonersMax += total;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*  70 */     this.indu.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*  75 */     this.indu.load(saveFile);
/*  76 */     this.prisonersMax = 0;
/*  77 */     this.prisonersCurrent = 0;
/*  78 */     for (PrisonInstance ins : all()) {
/*  79 */       this.prisonersCurrent += ins.prisoners();
/*  80 */       if (ins.active()) {
/*  81 */         this.prisonersMax += ins.prisonersMax();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/*  88 */     this.indu.clear();
/*  89 */     this.prisonersCurrent = 0;
/*  90 */     this.prisonersMax = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  97 */     return null;
/*     */   }
/*     */   
/*     */   public COORDINATE registerPrisoner(COORDINATE last, COORDINATE current) {
/* 101 */     if (this.prisonersCurrent >= this.prisonersMax) {
/* 102 */       return null;
/*     */     }
/* 104 */     if (SETT.IN_BOUNDS(last)) {
/* 105 */       PrisonInstance ins = (PrisonInstance)this.getter.get(last);
/* 106 */       if (ins != null && ins.active() && ins.prisoners() < ins.prisonersMax() && 
/* 107 */         (SETT.PATH()).comps.superComp.get(current) == (SETT.PATH()).comps.superComp.get(ins.mX(), ins.mY())) {
/* 108 */         return ins.registerPrisoner(last);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 113 */     int i = RND.rInt(instancesSize()); int k;
/* 114 */     for (k = 0; k < instancesSize(); k++) {
/* 115 */       PrisonInstance ins = (PrisonInstance)getInstance((k + i) % instancesSize());
/* 116 */       if (ins.active() && ins.prisoners() < ins.prisonersMax() && 
/* 117 */         (SETT.PATH()).comps.superComp.get(current) == (SETT.PATH()).comps.superComp.get(ins.mX(), ins.mY())) {
/* 118 */         return ins.registerPrisoner(last);
/*     */       }
/*     */     } 
/*     */     
/* 122 */     for (k = 0; k < instancesSize(); k++) {
/* 123 */       PrisonInstance ins = (PrisonInstance)getInstance((k + i) % instancesSize());
/* 124 */       if (ins.active() && ins.prisoners() < ins.prisonersMax()) {
/* 125 */         LOG.ln("exists!");
/* 126 */         return null;
/*     */       } 
/*     */     } 
/*     */     
/* 130 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public void unregisterPrisoner(COORDINATE c) {
/* 134 */     if (is(c)) {
/* 135 */       ((PrisonInstance)this.getter.get(c)).removePrisoner(c.x(), c.y());
/*     */     }
/*     */   }
/*     */   
/*     */   public FSERVICE getFood(COORDINATE cell) {
/* 140 */     if (is(cell))
/* 141 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 142 */         DIR dir = (DIR)DIR.ORTHO.get(di);
/* 143 */         FSERVICE f = Food.init(cell.x() + dir.x(), cell.y() + dir.y());
/* 144 */         if (f != null) {
/* 145 */           int dx = cell.x() + dir.perpendicular().x();
/* 146 */           int dy = cell.y() + dir.perpendicular().y();
/* 147 */           if (Latrine.init(dx, dy) != null) {
/* 148 */             return f;
/*     */           }
/*     */         } 
/*     */       }  
/* 152 */     return null;
/*     */   }
/*     */   
/*     */   public FSERVICE getLatrine(COORDINATE cell) {
/* 156 */     if (is(cell))
/* 157 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 158 */         DIR dir = (DIR)DIR.ORTHO.get(di);
/* 159 */         FSERVICE f = Latrine.init(cell.x() + dir.x(), cell.y() + dir.y());
/* 160 */         if (f != null) {
/* 161 */           int dx = cell.x() + dir.perpendicular().x();
/* 162 */           int dy = cell.y() + dir.perpendicular().y();
/* 163 */           if (Food.init(dx, dy) != null) {
/* 164 */             return f;
/*     */           }
/*     */         } 
/*     */       }  
/* 168 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isWithinCell(int nx, int ny, COORDINATE cell) {
/* 172 */     if (is(nx, ny) && is(cell.x(), cell.y())) {
/* 173 */       return this.constructor.isWithinCell(nx, ny, cell.x(), cell.y());
/*     */     }
/* 175 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isDoor(COORDINATE cell) {
/* 179 */     return (is(cell) && (SETT.ROOMS()).fData.tileData.get(cell) == 1);
/*     */   }
/*     */   
/*     */   public boolean isreserved(COORDINATE cell) {
/* 183 */     return (is(cell) && ((PrisonInstance)this.getter.get(cell)).isReserved(cell.x(), cell.y()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 188 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\prison\ROOM_PRISON.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */