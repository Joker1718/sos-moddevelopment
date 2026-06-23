/*    */ package settlement.room.infra.elderly;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import settlement.path.finders.SFinderRoomService;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.main.category.RoomCategorySub;
/*    */ import settlement.room.main.employment.RoomEmploymentSimple;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ public final class ROOM_RESTHOME
/*    */   extends RoomBlueprintIns<ResthomeInstance> {
/*    */   final ResthomeConstructor constructor;
/* 23 */   final Job job = new Job(this);
/* 24 */   public final RoomEmploymentSimple.EmployerSimple emp = new RoomEmploymentSimple.EmployerSimple(employment());
/*    */   
/*    */   public ROOM_RESTHOME(String key, int index, RoomInitData init, RoomCategorySub block) throws IOException {
/* 27 */     super(index, init, key, block);
/*    */ 
/*    */     
/* 30 */     this.constructor = new ResthomeConstructor(this, init);
/* 31 */     clearP();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update(double ds) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public SFinderRoomService service(int tx, int ty) {
/* 41 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void saveP(FilePutter f) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void loadP(FileGetter f) throws IOException {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void clearP() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public Furnisher constructor() {
/* 62 */     return this.constructor;
/*    */   }
/*    */ 
/*    */   
/*    */   public void appendView(LISTE<UIRoomModule> mm) {
/* 67 */     mm.add(this.constructor.quality.applier(this));
/*    */   }
/*    */   
/*    */   public DIR sitDir(COORDINATE c) {
/* 71 */     if ((SETT.ROOMS()).fData.tileData.get(c) == 3)
/* 72 */       return (DIR)DIR.ORTHO.get((SETT.ROOMS()).fData.spriteData.get(c) & 0x3); 
/* 73 */     return null;
/*    */   }
/*    */   
/*    */   public boolean dance(COORDINATE c) {
/* 77 */     if ((SETT.ROOMS()).fData.tileData.get(c) == 2)
/* 78 */       return true; 
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public boolean cards(COORDINATE c) {
/* 83 */     if ((SETT.ROOMS()).fData.tileData.get(c) == 1)
/* 84 */       return true; 
/* 85 */     return false;
/*    */   }
/*    */   
/*    */   public double quality(RoomInstance t) {
/* 89 */     return this.constructor.quality.get(t) * (1.0D - t.getDegrade());
/*    */   }
/*    */   
/*    */   public double quality() {
/* 93 */     return getStat(this.constructor.quality.index()) * (1.0D - degradeAverage());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\elderly\ROOM_RESTHOME.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */