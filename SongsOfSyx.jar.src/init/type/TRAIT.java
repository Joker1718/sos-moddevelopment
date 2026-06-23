/*    */ package init.type;
/*    */ import game.battle.div.Div;
/*    */ import game.boosting.BValue;
/*    */ import game.boosting.BoostSpecs;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.race.bio.BioLine;
/*    */ import init.sprite.UI.UI;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.colls.StatsTraits;
/*    */ import settlement.stats.util.StatBooster;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.info.INFO;
/*    */ import util.keymap.MAPPED;
/*    */ import util.text.D;
/*    */ 
/*    */ public final class TRAIT implements MAPPED {
/* 24 */   private static CharSequence ¤¤name = "Trait"; private final String key;
/*    */   
/*    */   static {
/* 27 */     D.ts(TRAIT.class);
/*    */   }
/*    */ 
/*    */   
/*    */   private final int index;
/*    */   public final INFO info;
/*    */   public final CharSequence rTitle;
/*    */   public final BoostSpecs boosters;
/*    */   public final CharSequence[] bios;
/* 36 */   final double[] occRaces = new double[RACES.all().size()];
/*    */   
/* 38 */   final ArrayListGrower<TRAIT> disables = new ArrayListGrower();
/*    */   
/*    */   TRAIT(LISTE<TRAIT> all, String key, Json data, Json jtext) {
/* 41 */     this.key = key;
/* 42 */     this.index = all.add(this);
/* 43 */     this.info = new INFO(jtext);
/* 44 */     this.rTitle = jtext.text("TITLE");
/* 45 */     this.bios = BioLine.insert.check((CharSequence[])jtext.texts("BIO_DESC"));
/* 46 */     RACES.map().readFill("DEFAULT_RACE_OCCURANCE", this.occRaces, data, 0.0D, 1.0D);
/* 47 */     this.boosters = new BoostSpecs(String.valueOf(¤¤name) + ": " + String.valueOf(¤¤name), (SPRITE)(UI.icons()).s.alert, true);
/*    */     
/* 49 */     this.boosters.read(data, (BValue)new StatBooster()
/*    */         {
/*    */           public double vGet(Induvidual indu)
/*    */           {
/* 53 */             return TRAIT.this.stat().getD(indu);
/*    */           }
/*    */ 
/*    */           
/*    */           public double vGet(Div div) {
/* 58 */             return TRAIT.this.stat().getD(div);
/*    */           }
/*    */ 
/*    */           
/*    */           public double vGet(FactionNPC f) {
/* 63 */             return vGet((f.court().king().roy()).induvidual);
/*    */           }
/*    */           
/*    */           public double vGet(HCLASS_RACE popTime) {
/* 67 */             return TRAIT.this.stat().getD(popTime.cl, popTime.race);
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int index() {
/* 76 */     return this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   public String key() {
/* 81 */     return this.key;
/*    */   }
/*    */   
/*    */   public LIST<TRAIT> disables() {
/* 85 */     return (LIST<TRAIT>)this.disables;
/*    */   }
/*    */   
/*    */   public double get(Induvidual in) {
/* 89 */     return STATS.TRAITS().stat(this).getD(in);
/*    */   }
/*    */   
/*    */   public double occurance(Race race) {
/* 93 */     return this.occRaces[race.index];
/*    */   }
/*    */   
/*    */   public StatsTraits.StatTrait stat() {
/* 97 */     return STATS.TRAITS().stat(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\TRAIT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */