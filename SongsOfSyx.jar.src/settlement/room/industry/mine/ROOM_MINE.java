/*     */ package settlement.room.industry.mine;
/*     */ 
/*     */ import game.boosting.Boostable;
/*     */ import init.resources.Minable;
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import java.io.IOException;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRegion;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public final class ROOM_MINE extends RoomBlueprintIns<MineInstance> implements INDUSTRY_HASER {
/*  32 */   int rawNeeded = 2;
/*     */   
/*     */   public static final String type = "MINE";
/*     */   
/*     */   final Job job;
/*     */   
/*     */   final Industry productionData;
/*     */   final Constructor constructor;
/*     */   public final Minable minable;
/*     */   final LIST<Industry> indus;
/*     */   
/*     */   public ROOM_MINE(RoomInitData init, String key, int index, RoomCategorySub cat) throws IOException {
/*  44 */     super(index, init, key, cat);
/*     */     
/*  46 */     this.minable = (Minable)RESOURCES.minables().read(init.data());
/*  47 */     this.constructor = new Constructor(init, this);
/*  48 */     Boostable skill = pushBo(init.data(), "MINE", true);
/*  49 */     D.t(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  83 */     this.productionData = new Industry((RoomBlueprintImp)this, this.minable.resource, init.data().d("YEILD_WORKER_DAILY", 0.0D, 1000.0D), skill);
/*  84 */     this.productionData.roomBoosts.add(this.constructor.efficiency);
/*  85 */     this.productionData.roomBoosts.add(this.constructor.deposits);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     this.job = new Job(this, init.data().i("STORAGE", 4, 500));
/* 101 */     this.indus = (LIST<Industry>)new ArrayList(this.productionData);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 108 */     return this.constructor;
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
/*     */   public SFinderRoomService service(int tx, int ty) {
/* 121 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/* 126 */     this.productionData.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/* 131 */     this.productionData.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 136 */     this.productionData.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean makesDudesDirty() {
/* 141 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 146 */     mm.add(this.constructor.deposits.applier(this));
/* 147 */     mm.add(this.constructor.efficiency.applier(this));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     mm.add(new UIRoomModule()
/*     */         {
/*     */           public void hover(GBox box, Room i, int rx, int ry) {
/* 167 */             box.NL();
/* 168 */             box.add((SPRITE)box.text().add(((MineInstance)i).workage));
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<Industry> industries() {
/* 175 */     return this.indus;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\mine\ROOM_MINE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */