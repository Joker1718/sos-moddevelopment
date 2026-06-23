/*    */ package settlement.room.service.hygine.bath;
/*    */ 
/*    */ import game.boosting.Boostable;
/*    */ import java.io.IOException;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.room.industry.module.Industry;
/*    */ import settlement.room.industry.module.IndustryResource;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends Industry
/*    */ {
/*    */   null(RoomBlueprintImp $anonymous0, Json $anonymous1, Boostable $anonymous2) throws IOException {
/* 61 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   public double consumptionRate(RoomInstance ins, Humanoid h, IndustryResource oo) {
/* 64 */     BathInstance i = (BathInstance)ins;
/* 65 */     if (ins.employees().employed() == 0)
/* 66 */       return 0.0D; 
/* 67 */     return oo.rate * i.service.total() / ins.employees().employed();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\bath\ROOM_BATH$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */