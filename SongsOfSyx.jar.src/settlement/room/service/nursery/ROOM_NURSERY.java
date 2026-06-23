/*     */ package settlement.room.service.nursery;
/*     */ 
/*     */ import game.VERSION;
/*     */ import game.boosting.Boostable;
/*     */ import init.type.NEED;
/*     */ import java.io.IOException;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.RoomBoost;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.service.StatServiceChild;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_NURSERY extends RoomBlueprintIns<NurseryInstance> implements RoomService.ROOM_SERVICE_HASER {
/*  30 */   public final String type = "NURSERY";
/*     */   
/*     */   final NurseryConstructor constructor;
/*     */   
/*     */   final NurseryStation ss;
/*     */   final RoomService service;
/*     */   public final IndustryRate rate;
/*     */   public static final double playTime = 120.0D;
/*  38 */   public final double ChildPErE = 10.0D;
/*     */ 
/*     */   
/*     */   public ROOM_NURSERY(int index, RoomInitData init, RoomCategorySub block, String key) throws IOException {
/*  42 */     super(index, init, key, block);
/*     */ 
/*     */     
/*  45 */     this.ss = new NurseryStation(this);
/*  46 */     this.constructor = new NurseryConstructor(this, init);
/*  47 */     pushBo(init.data(), "NURSERY", true);
/*     */     
/*  49 */     this.service = new RoomService((RoomBlueprintImp)this, init, null)
/*     */       {
/*     */         public FSERVICE service(int tx, int ty)
/*     */         {
/*  53 */           return ROOM_NURSERY.this.ss.service(tx, ty);
/*     */         }
/*     */ 
/*     */         
/*     */         public double totalMultiplier() {
/*  58 */           return 1.0D;
/*     */         }
/*     */       };
/*     */     
/*  62 */     this.rate = new IndustryRate()
/*     */       {
/*  64 */         private final ArrayList<RoomBoost> boos = new ArrayList(ROOM_NURSERY.this.constructor.coziness);
/*     */ 
/*     */         
/*     */         public LIST<RoomBoost> boosts() {
/*  68 */           return (LIST<RoomBoost>)this.boos;
/*     */         }
/*     */ 
/*     */         
/*     */         public Boostable bonus() {
/*  73 */           return ROOM_NURSERY.this.bonus;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/*  88 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  93 */     return this.service.finder;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*  98 */     this.service.saver.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/* 103 */     if (VERSION.versionIsBefore(71, 38)) {
/* 104 */       this.service.loadFix(this);
/*     */     } else {
/*     */       
/* 107 */       this.service.saver.load(saveFile);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 113 */     this.service.saver.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 119 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomService service() {
/* 124 */     return this.service;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FSERVICE getOther(COORDINATE c) {
/* 132 */     NurseryInstance ins = (NurseryInstance)get(c.x(), c.y());
/* 133 */     if (ins != null) {
/*     */       
/* 135 */       COORDINATE t = ins.getWork().get(RND.rInt(ins.getWork().size()));
/* 136 */       FSERVICE s = this.ss.service(t.x(), t.y());
/* 137 */       if (s.findableReservedCanBe()) {
/* 138 */         return s;
/*     */       }
/*     */     } 
/* 141 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public StatServiceChild stat() {
/* 146 */     return (StatServiceChild)(STATS.SERVICE()).nurseries.get(typeIndex());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\nursery\ROOM_NURSERY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */