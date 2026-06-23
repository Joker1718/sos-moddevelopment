/*    */ package settlement.room.home.chamber;
/*    */ 
/*    */ import init.sprite.game.Sheets;
/*    */ import java.io.IOException;
/*    */ import settlement.room.sprite.RoomSpriteXxX;
/*    */ import util.rendering.RenderData;
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
/*    */   extends RoomSpriteXxX
/*    */ {
/*    */   null(int $anonymous0) throws IOException {
/* 48 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public Sheets sheet(RenderData.RenderIterator it) {
/* 52 */     ChamberInstance ins = (ChamberInstance)blue.get(it.tx(), it.ty());
/* 53 */     if (ins != null && ins.occupant() != null)
/* 54 */       return (ins.occupant().race().home().clas(ins.occupant().indu())).masterBed.get(ins); 
/* 55 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\chamber\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */