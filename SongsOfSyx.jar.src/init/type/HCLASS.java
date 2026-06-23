/*    */ package init.type;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.sprite.UI.Icon;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import util.info.INFO;
/*    */ import util.keymap.MAPPED;
/*    */ 
/*    */ public abstract class HCLASS
/*    */   extends INFO implements MAPPED {
/*    */   HCLASS(LISTE<HCLASS> all, LISTE<HCLASS> allP, String key, CharSequence name, CharSequence names, CharSequence desc, boolean player, COLOR color) {
/* 13 */     super(name, names, desc, null);
/* 14 */     this.player = player;
/* 15 */     if (player) {
/* 16 */       this.playerIndex = allP.add(this);
/*    */     } else {
/* 18 */       this.playerIndex = -1;
/*    */     } 
/* 20 */     this.color = color;
/* 21 */     this.index = all.add(this);
/* 22 */     this.key = key;
/*    */   }
/*    */   private final int index;
/*    */   public final boolean player;
/*    */   public final COLOR color;
/*    */   public final String key;
/*    */   public final int playerIndex;
/*    */   
/*    */   public abstract Icon icon();
/*    */   
/*    */   public abstract Icon iconSmall();
/*    */   
/*    */   public String toString() {
/* 35 */     return String.valueOf(this.name) + "#" + String.valueOf(this.name);
/*    */   }
/*    */ 
/*    */   
/*    */   public int index() {
/* 40 */     return this.index;
/*    */   }
/*    */   
/*    */   public HCLASS_RACE get(Race race) {
/* 44 */     return HCLASS_RACE.clP(race, this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String key() {
/* 49 */     return this.key;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\HCLASS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */