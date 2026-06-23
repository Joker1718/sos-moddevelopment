/*    */ package settlement.room.health.hospital;
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
/*    */ class null
/*    */   extends Industry
/*    */ {
/*    */   null(RoomBlueprintImp $anonymous0, Json $anonymous1, Boostable $anonymous2) throws IOException {
/* 59 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public double consumptionRate(RoomInstance ins, Humanoid h, IndustryResource oo) {
/* 63 */     HospitalInstance ii = (HospitalInstance)ins;
/* 64 */     double n = ii.service().load() * ii.service().total();
/* 65 */     if (!ii.fetch[oo.index()])
/* 66 */       n = 0.0D; 
/* 67 */     if (ii.employees().employed() == 0)
/* 68 */       return 0.0D; 
/* 69 */     return n / ii.employees().employed();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\hospital\ROOM_HOSPITAL$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */