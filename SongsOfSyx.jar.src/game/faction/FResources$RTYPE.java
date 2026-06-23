/*     */ package game.faction;
/*     */ 
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum RTYPE
/*     */ {
/*  99 */   PRODUCED(Dic.¤¤Production),
/* 100 */   CONSUMED(Dic.¤¤Consumed),
/* 101 */   TRADE(Dic.¤¤Trade),
/* 102 */   TAX(Dic.¤¤taxes),
/* 103 */   CONSTRUCTION(Dic.¤¤construction),
/* 104 */   FURNISH(FResources.¤¤worn),
/* 105 */   EQUIPPED(Dic.¤¤Equipped),
/* 106 */   MAINTENANCE(Dic.¤¤Maintenance),
/* 107 */   SPOILAGE(Dic.¤¤Spoilage),
/* 108 */   ARMY_SUPPLY(String.valueOf(Dic.¤¤Supplies) + ": " + String.valueOf(Dic.¤¤Supplies)),
/* 109 */   SPOILS(String.valueOf(Dic.¤¤Battle) + ": " + String.valueOf(Dic.¤¤Battle)),
/* 110 */   DIPLOMACY(Dic.¤¤Diplomacy),
/* 111 */   THEFT(FResources.¤¤theft);
/*     */   public static final LIST<RTYPE> all;
/*     */   
/*     */   static {
/* 115 */     all = (LIST<RTYPE>)new ArrayList((Object[])values());
/*     */   }
/*     */   public final CharSequence name;
/*     */   
/*     */   RTYPE(CharSequence name) {
/* 120 */     this.name = name;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FResources$RTYPE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */