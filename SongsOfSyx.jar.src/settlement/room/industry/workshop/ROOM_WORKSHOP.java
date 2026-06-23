/*    */ package settlement.room.industry.workshop;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import settlement.path.finders.SFinderRoomService;
/*    */ import settlement.room.industry.module.INDUSTRY_HASER;
/*    */ import settlement.room.industry.module.Industry;
/*    */ import settlement.room.industry.module.IndustryUtil;
/*    */ import settlement.room.industry.module.RoomBoost;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.category.RoomCategorySub;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ public class ROOM_WORKSHOP
/*    */   extends RoomBlueprintIns<WorkshopInstance> implements INDUSTRY_HASER {
/*    */   public static final String type = "WORKSHOP";
/*    */   final Job job;
/*    */   final Constructor constructor;
/*    */   final LIST<Industry> indus;
/*    */   
/*    */   public ROOM_WORKSHOP(int index, RoomInitData init, String key, RoomCategorySub cat) throws IOException {
/* 29 */     super(index, init, key, cat);
/*    */     
/* 31 */     this.constructor = new Constructor(this, init);
/* 32 */     pushBo(init.data(), "WORKSHOP", true);
/*    */     
/* 34 */     this.job = new Job(this);
/*    */     
/* 36 */     this.indus = Industry.createIndustries((RoomBlueprintImp)this, init, new RoomBoost[] { (RoomBoost)this.constructor.efficiency }, bonus());
/*    */     
/* 38 */     employment().countInputSet();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update(double ds) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SFinderRoomService service(int tx, int ty) {
/* 50 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void saveP(FilePutter saveFile) {
/* 55 */     IndustryUtil.save(saveFile, this.indus);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void loadP(FileGetter saveFile) throws IOException {
/* 60 */     IndustryUtil.load(saveFile, this.indus);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clearP() {
/* 65 */     IndustryUtil.clear(this.indus);
/*    */   }
/*    */ 
/*    */   
/*    */   public Furnisher constructor() {
/* 70 */     return this.constructor;
/*    */   }
/*    */ 
/*    */   
/*    */   public LIST<Industry> industries() {
/* 75 */     return this.indus;
/*    */   }
/*    */   
/*    */   public void appendView(LISTE<UIRoomModule> mm) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\workshop\ROOM_WORKSHOP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */