/*    */ package game.faction.npc;
/*    */ 
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import world.region.pop.RDRace;
/*    */ 
/*    */ public abstract class NPCResource
/*    */ {
/*    */   protected NPCResource(LISTE<NPCResource> all) {
/* 10 */     all.add(this);
/*    */   }
/*    */   
/*    */   protected abstract SAVABLE saver();
/*    */   
/*    */   protected abstract void update(FactionNPC paramFactionNPC, double paramDouble);
/*    */   
/*    */   protected abstract void generate(RDRace paramRDRace, FactionNPC paramFactionNPC, boolean paramBoolean);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\NPCResource.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */