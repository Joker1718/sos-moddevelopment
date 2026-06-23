/*     */ package init.tech;
/*     */ 
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import init.value.Lockers;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.info.INFO;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TECH
/*     */   implements INDEXED
/*     */ {
/*     */   public final COLOR color;
/*     */   private final int index;
/*     */   public final int levelMax;
/*     */   public final LIST<TechCost> costs;
/*     */   public final int costTotal;
/*     */   public final double levelCostInc;
/*     */   private LIST<TechRequirement> needs;
/*     */   private LIST<TechRequirement> needsPruned;
/*     */   private final INFO info;
/*     */   public final BoostSpecs boosters;
/*     */   public final Lockable<Faction> requires;
/*     */   public final Lockers lockers;
/*  46 */   private SPRITE icon = null;
/*     */   
/*     */   public final String key;
/*     */   public final TechTree tree;
/*     */   public final double AIAmount;
/*     */   Json requiresTech;
/*     */   
/*     */   TECH(TechCurrency.TechCurrencies cc, String key, LISTE<TECH> all, Json data, Json text, TechTree tree, int xx, int yy) throws IOException {
/*  54 */     this.key = key;
/*  55 */     this.tree = tree;
/*  56 */     if (text != null) {
/*  57 */       this.info = new INFO(text);
/*     */     } else {
/*  59 */       this.info = new INFO(String.valueOf(tree.name) + " " + String.valueOf(tree.name) + ":" + xx + 1, Dic.empty);
/*  60 */     }  this.index = all.add(this);
/*  61 */     this.levelMax = data.i("LEVEL_MAX", 1, 10000, 1);
/*  62 */     this.costs = cc.read(data);
/*  63 */     int a = 0;
/*  64 */     for (TechCost c : this.costs)
/*  65 */       a = (int)(a + c.amount); 
/*  66 */     this.costTotal = a;
/*  67 */     this.levelCostInc = data.dTry("LEVEL_COST_INC", 0.0D, 100000.0D, 0.0D);
/*  68 */     if (data.has("LEVEL_COST_INC_MUL"))
/*  69 */       LOG.ln(key); 
/*  70 */     this.AIAmount = data.dTry("AI_AMOUNT", 0.0D, 1.0D, 1.0D);
/*  71 */     this.requires = GVALUES.FACTION.LOCK.push();
/*  72 */     this.requires.push(data);
/*  73 */     this.lockers = new Lockers(String.valueOf(Dic.¤¤TechnologyShort) + ": " + String.valueOf(Dic.¤¤TechnologyShort), (SPRITE)(UI.icons()).s.vial);
/*     */     
/*  75 */     if (data.has("COLOR")) {
/*  76 */       this.color = (COLOR)new ColorImp(data);
/*     */     } else {
/*  78 */       this.color = tree.color;
/*     */     } 
/*  80 */     this.lockers.add(GVALUES.FACTION, data, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction t)
/*     */           {
/*  84 */             if (t == FACTIONS.player()) {
/*  85 */               if ((FACTIONS.player()).tech.isPenaltyLocked(TECH.this))
/*  86 */                 return 0.0D; 
/*  87 */               return (((FACTIONS.player()).tech.level(TECH.this) > 0) ? true : false);
/*     */             } 
/*  89 */             return 1.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  94 */     this.lockers.add(GVALUES.INDU, data, new DOUBLE_O<Induvidual>()
/*     */         {
/*     */           public double getD(Induvidual t)
/*     */           {
/*  98 */             if (t.faction() == FACTIONS.player()) {
/*  99 */               if ((FACTIONS.player()).tech.isPenaltyLocked(TECH.this))
/* 100 */                 return 0.0D; 
/* 101 */               return (((FACTIONS.player()).tech.level(TECH.this) > 0) ? true : false);
/*     */             } 
/* 103 */             return 1.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 108 */     this.lockers.add(GVALUES.REGION, data, new DOUBLE_O<Region>()
/*     */         {
/*     */           public double getD(Region t)
/*     */           {
/* 112 */             if (t.faction() == FACTIONS.player()) {
/* 113 */               if ((FACTIONS.player()).tech.isPenaltyLocked(TECH.this))
/* 114 */                 return 0.0D; 
/* 115 */               return (((FACTIONS.player()).tech.level(TECH.this) > 0) ? true : false);
/*     */             } 
/* 117 */             return 1.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 122 */     this.boosters = new BoostSpecs(this.info.name, (SPRITE)(UI.icons()).s.vial, false);
/* 123 */     this.boosters.read(data, null);
/*     */     
/* 125 */     if (data.has("ICON")) {
/* 126 */       this.icon = (UI.icons().get(data)).huge;
/*     */     }
/* 128 */     this.requiresTech = data;
/*     */     
/* 130 */     data.has("REQUIRES_TECH_LEVEL");
/*     */     
/* 132 */     data.checkUnused();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int index() {
/* 138 */     return this.index;
/*     */   }
/*     */   
/*     */   public LIST<TechRequirement> requires() {
/* 142 */     return this.needs;
/*     */   }
/*     */   
/*     */   public LIST<TechRequirement> requiresNodes() {
/* 146 */     return this.needsPruned;
/*     */   }
/*     */   
/*     */   void set(LIST<TechRequirement> needs) {
/* 150 */     this.needs = needs;
/*     */   }
/*     */   
/*     */   void prune(LIST<TechRequirement> needs) {
/* 154 */     this.needsPruned = needs;
/*     */   }
/*     */   
/*     */   public boolean requires(TECH other, int level) {
/* 158 */     if (other == this)
/* 159 */       return false; 
/* 160 */     for (int i = 0; i < this.needs.size(); i++) {
/* 161 */       TECH t = ((TechRequirement)this.needs.get(i)).tech;
/* 162 */       if ((t == other || t.requires(other, ((TechRequirement)this.needs.get(i)).level)) && 
/* 163 */         ((TechRequirement)this.needs.get(i)).level > level)
/* 164 */         return true; 
/*     */     } 
/* 166 */     return false;
/*     */   }
/*     */   
/*     */   public SPRITE icon() {
/* 170 */     if (this.icon == null) {
/* 171 */       this.icon = TechIcon.icon(this);
/*     */     }
/* 173 */     return this.icon;
/*     */   }
/*     */   
/*     */   public static final class TechRequirement
/*     */   {
/*     */     public final TECH tech;
/*     */     public final int level;
/*     */     
/*     */     TechRequirement(TECH t, int l) {
/* 182 */       this.tech = t;
/* 183 */       this.level = l;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object obj) {
/* 188 */       if (obj instanceof TechRequirement) {
/* 189 */         TechRequirement q = (TechRequirement)obj;
/* 190 */         return (q.level == this.level && q.tech == this.tech);
/*     */       } 
/* 192 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 198 */     return this.info.name;
/*     */   }
/*     */   
/*     */   public CharSequence desc() {
/* 202 */     return this.info.desc;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\tech\TECH.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */