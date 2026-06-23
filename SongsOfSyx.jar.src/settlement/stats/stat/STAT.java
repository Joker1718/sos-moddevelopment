/*     */ package settlement.stats.stat;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BoostSpecs;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.util.StatHoverer;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.INFO;
/*     */ 
/*     */ public abstract class STAT
/*     */   implements INDEXED, SETT_STATISTICS {
/*     */   private StatDecree decree;
/*     */   private final int index;
/*     */   protected final String key;
/*     */   
/*     */   protected STAT(String key, StatsInit init, StatInfo info) {
/*  27 */     this.index = init.stats.add(this);
/*  28 */     init.coll.all.add(this);
/*  29 */     if (key != null) {
/*  30 */       key = init.coll.key + "_" + init.coll.key;
/*  31 */       key = key.replace("__", "_");
/*     */     } 
/*  33 */     this.key = key;
/*  34 */     if (info == null && key != null)
/*  35 */       info = new StatInfo(init.dText.json(key)); 
/*  36 */     if (key != null)
/*  37 */       init.statMap.put(key, this); 
/*  38 */     if (info != null) {
/*  39 */       this.info = new StatInfo(info);
/*     */     } else {
/*  41 */       this.info = new StatInfo("no use", "no use");
/*  42 */       this.info.setMatters(false, false);
/*     */     } 
/*  44 */     this.boosters = new BoostSpecs((info == null) ? "" : info.name, (SPRITE)(UI.icons()).s.human, true);
/*     */   }
/*     */   
/*     */   protected final StatInfo info;
/*     */   public StatStanding standing;
/*     */   public final BoostSpecs boosters;
/*     */   
/*     */   public final StatInfo info() {
/*  52 */     return this.info;
/*     */   }
/*     */   
/*     */   public final StatStanding standing() {
/*  56 */     return this.standing;
/*     */   }
/*     */   
/*     */   public final String key() {
/*  60 */     return this.key;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addDecree(StatDecree d) {
/*  66 */     this.decree = d;
/*     */   }
/*     */   
/*     */   public StatDecree decree() {
/*  70 */     return this.decree;
/*     */   }
/*     */   
/*     */   public boolean hasIndu() {
/*  74 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int index() {
/*  79 */     return this.index;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, HCLASS cl, Race type) {
/*  85 */     StatHoverer.hover(text, this);
/*  86 */     GBox b = (GBox)text;
/*  87 */     b.sep();
/*  88 */     StatHoverer.hover(text, this, cl, type);
/*  89 */     b.NL();
/*  90 */     if (this.boosters.all().size() > 0) {
/*  91 */       this.boosters.hover(text, (BOOSTABLE_O)HCLASS_RACE.clP(type, cl));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, Induvidual indu) {
/*  97 */     StatHoverer.hover(text, this);
/*  98 */     GBox b = (GBox)text;
/*  99 */     b.sep();
/* 100 */     StatHoverer.hover(text, this, indu);
/* 101 */     b.NL();
/* 102 */     if (this.boosters.all().size() > 0) {
/* 103 */       b.NL(8);
/* 104 */       this.boosters.hover(text, (BOOSTABLE_O)indu);
/*     */     } 
/*     */   }
/*     */   
/*     */   public abstract INT_O.INT_OE<Induvidual> indu();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\STAT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */