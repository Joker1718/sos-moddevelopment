/*    */ package settlement.room.infra.janitor;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import util.data.GETTER;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GuiSection
/*    */ {
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 69 */     Gui.this.maxAm = 0;
/* 70 */     for (RESOURCE res : RESOURCES.ALL()) {
/* 71 */       resourceI[res.index()] = null;
/*    */     }
/* 73 */     for (RESOURCE res : RESOURCES.ALL()) {
/*    */       
/* 75 */       if (SETT.MAINTENANCE().estimateGlobal(res) > 0.0D) {
/* 76 */         resourceI[Gui.this.maxAm] = res;
/* 77 */         Gui.this.maxAm++;
/*    */       } 
/*    */     } 
/* 80 */     (SETT.OVERLAY()).MAINTENANCE.add((RoomInstance)getter.get());
/* 81 */     super.render(r, ds);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\janitor\Gui$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */