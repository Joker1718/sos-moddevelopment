/*    */ package game.faction.player.emmi;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import game.faction.royalty.Royalty;
/*    */ import java.util.Arrays;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ 
/*    */ public abstract class EmiTypeRoy
/*    */   extends EmiType<Royalty>
/*    */ {
/* 14 */   private final int[] ftot = Alloc.ii(FACTIONS.MAX());
/*    */   
/*    */   EmiTypeRoy(SPRITE icon, CharSequence name, CharSequence desc) {
/* 17 */     super(icon, name, desc, FACTIONS.MAX() * 4, 1000);
/*    */   }
/*    */   
/*    */   public int total(FactionNPC f) {
/* 21 */     return this.ftot[f.index()];
/*    */   }
/*    */ 
/*    */   
/*    */   void count(int index, int am) {
/* 26 */     this.ftot[index / 4] = this.ftot[index / 4] + am;
/* 27 */     super.count(index, am);
/*    */   }
/*    */ 
/*    */   
/*    */   void clear() {
/* 32 */     Arrays.fill(this.ftot, 0);
/* 33 */     super.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   int index(Royalty t) {
/* 38 */     return t.court.faction.index() * 4 + t.successionI();
/*    */   }
/*    */   
/*    */   void clear(FactionNPC f) {
/* 42 */     int k = f.index() * 4;
/* 43 */     for (int i = 0; i < 4; i++)
/* 44 */       set(k + i, 0); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\emmi\EmiTypeRoy.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */