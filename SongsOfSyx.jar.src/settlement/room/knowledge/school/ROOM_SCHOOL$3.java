/*    */ package settlement.room.knowledge.school;
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
/*    */ 
/*    */ class null
/*    */   extends Industry
/*    */ {
/*    */   null(RoomBlueprintImp $anonymous0, Json $anonymous1, Boostable $anonymous2) throws IOException {
/* 62 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public double consumptionRate(RoomInstance ins, Humanoid h, IndustryResource oo) {
/* 66 */     if (ins.employees().employed() == 0)
/* 67 */       return 0.0D; 
/* 68 */     double d = oo.rate * ROOM_SCHOOL.this.service.load() * ROOM_SCHOOL.this.service.total() / ins.employees().employed();
/* 69 */     return d;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\school\ROOM_SCHOOL$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */