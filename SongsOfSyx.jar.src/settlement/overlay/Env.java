/*    */ package settlement.overlay;
/*    */ 
/*    */ import settlement.environment.SettEnvMap;
/*    */ import snake2d.Renderer;
/*    */ import util.rendering.RenderData;
/*    */ 
/*    */ class Env
/*    */   extends Addable {
/*    */   final SettEnvMap.SettEnv envThing;
/*    */   
/*    */   Env(SettEnvMap.SettEnv env, boolean above) {
/* 12 */     super(env.icon, env.key, env.info.name, env.info.desc, true, above);
/* 13 */     this.envThing = env;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 18 */     renderUnder(this.envThing.getView(it.tx(), it.ty()), r, it);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\Env.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */