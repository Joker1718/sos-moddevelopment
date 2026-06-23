/*    */ package game.events.faction;
/*    */ 
/*    */ import game.events.EVENTS;
/*    */ import game.faction.FACTIONS;
/*    */ import game.time.TIME;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.rnd.RND;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ 
/*    */ public class EventFactionPopup
/*    */   extends EVENTS.EventResource
/*    */ {
/* 17 */   private static final double dtime = (TIME.secondsPerDay() * 16);
/* 18 */   private double timer = dtime;
/*    */   private int nextRegion;
/*    */   
/*    */   EventFactionPopup() {
/* 22 */     super("FACTION_POPUP");
/*    */   }
/*    */ 
/*    */   
/*    */   protected void update(double ds) {
/* 27 */     this.timer -= ds;
/* 28 */     if (this.timer > 0.0D) {
/*    */       return;
/*    */     }
/* 31 */     Region r = (Region)WORLD.REGIONS().active().getC(this.nextRegion);
/* 32 */     if (FACTIONS.active().size() > FACTIONS.MAX() - 16 || r == null || r.faction() != null) {
/* 33 */       clear();
/*    */       return;
/*    */     } 
/* 36 */     FACTIONS.activateNext(r, null, true);
/*    */     
/* 38 */     clear();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void save(FilePutter file) {
/* 44 */     file.d(this.timer);
/* 45 */     file.i(this.nextRegion);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {
/* 50 */     this.timer = file.d();
/* 51 */     this.nextRegion = file.i();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clear() {
/* 56 */     this.timer = RND.rFloat() * dtime;
/* 57 */     this.nextRegion = RND.rInt();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\faction\EventFactionPopup.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */