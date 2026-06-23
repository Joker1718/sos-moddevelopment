/*     */ package init.type;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.BOOLEANO;
/*     */ import util.info.INFO;
/*     */ import util.keymap.RMAP;
/*     */ import util.text.D;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public final class CLIMATES
/*     */ {
/*     */   public static final String KEY = "CLIMATE";
/*     */   private static Data d;
/*     */   
/*     */   CLIMATES() throws IOException {
/*  42 */     d = new Data();
/*     */   }
/*     */ 
/*     */   
/*     */   public static CLIMATE COLD() {
/*  47 */     return d.COLD;
/*     */   }
/*     */   
/*     */   public static CLIMATE TEMP() {
/*  51 */     return d.TEMPERATE;
/*     */   }
/*     */   
/*     */   public static CLIMATE HOT() {
/*  55 */     return d.HOT;
/*     */   }
/*     */   
/*     */   public static LIST<CLIMATE> ALL() {
/*  59 */     return (LIST<CLIMATE>)d.all;
/*     */   }
/*     */   
/*     */   public static RMAP<CLIMATE> MAP() {
/*  63 */     return d.map;
/*     */   }
/*     */   
/*     */   public static INFO INFO() {
/*  67 */     return d.info;
/*     */   }
/*     */   
/*     */   public static BoostSpecs BONUS() {
/*  71 */     return d.boosters;
/*     */   }
/*     */   
/*     */   public static void pushBonuses(Json json, Boostable bo) {
/*  75 */     if (!json.has("CLIMATE"))
/*     */       return; 
/*  77 */     double[] vv = new double[ALL().size()];
/*  78 */     Arrays.fill(vv, 1.0D);
/*  79 */     MAP().readFill(vv, json, 0.0D, 2000.0D);
/*  80 */     for (CLIMATE c : ALL()) {
/*  81 */       if (vv[c.index()] == 1.0D)
/*     */         continue; 
/*  83 */       c.boosters.pushPromise(bo, null, vv[c.index()], true);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static BoostSpec pushIfDoesntExist(CLIMATE c, double v, Boostable bo, boolean isMul) {
/*  90 */     String k = bo.key + bo.key;
/*  91 */     double none = (isMul ? true : false);
/*     */     
/*  93 */     if (d.bvmap.containsKey(k) && ((BV)d.bvmap.get(k)).values[c.index()] != none) {
/*  94 */       return null;
/*     */     }
/*     */     
/*  97 */     boolean ret = false;
/*  98 */     if (!d.bvmap.containsKey(k)) {
/*  99 */       ret = true;
/* 100 */       d.bvmap.put(k, new BV(d.boosters, bo, isMul));
/*     */     } 
/* 102 */     BV bv = (BV)d.bvmap.get(k);
/* 103 */     bv.set(c, v);
/* 104 */     c.boosters.push(bo, v, isMul);
/* 105 */     return ret ? bv.spec : null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class Data
/*     */   {
/*     */     private final CLIMATE COLD;
/*     */     private final CLIMATE TEMPERATE;
/*     */     private final CLIMATE HOT;
/* 114 */     private final ArrayList<CLIMATE> all = new ArrayList(3);
/*     */     private final INFO info;
/*     */     private final BoostSpecs boosters;
/* 117 */     private final KeyMap<CLIMATES.BV> bvmap = new KeyMap();
/*     */     private final RMAP<CLIMATE> map;
/*     */     
/*     */     Data() throws IOException {
/* 121 */       D.gInit(CLIMATES.class);
/* 122 */       this.info = new INFO(D.g("Climate"), D.g("desc", "Climate zones have a range of bonuses and drawbacks. They also have different base temperatures, which can lead to exposure and death for your subjects depending on their natural resilience to hot and cold."));
/* 123 */       CLIMATES.d = this;
/* 124 */       Json j = new Json((PATHS.CONFIG()).init.gets("CLIMATE"));
/* 125 */       this.COLD = new CLIMATE(
/* 126 */           (LISTE<CLIMATE>)this.all, "COLD", 
/* 127 */           D.g("Cold"), 
/* 128 */           D.g("cold_desc", "Very cold winters. Unique crops. Low disease rates."), 
/* 129 */           j);
/* 130 */       this.TEMPERATE = new CLIMATE(
/* 131 */           (LISTE<CLIMATE>)this.all, "TEMPERATE", 
/* 132 */           D.g("Temperate"), 
/* 133 */           D.g("temp_desc", "Varying temperature."), 
/* 134 */           j);
/* 135 */       this.HOT = new CLIMATE(
/* 136 */           (LISTE<CLIMATE>)this.all, "HOT", 
/* 137 */           D.g("Warm"), 
/* 138 */           D.g("warm_desc", "Hot summers."), 
/* 139 */           j);
/*     */       
/* 141 */       this.map = new RMAP("CLIMATE", (LIST)this.all);
/*     */       
/* 143 */       this.boosters = new BoostSpecs(this.info.name, (SPRITE)(UI.icons()).s.heat, true);
/*     */       
/* 145 */       ACTION a = new ACTION()
/*     */         {
/*     */           
/*     */           public void exe()
/*     */           {
/* 150 */             for (CLIMATE c : CLIMATES.ALL()) {
/*     */               
/* 152 */               for (BoostSpec s : c.boosters.all()) {
/* 153 */                 String k = s.boostable.key + s.boostable.key;
/* 154 */                 if (!CLIMATES.Data.this.bvmap.containsKey(k)) {
/* 155 */                   CLIMATES.Data.this.bvmap.put(k, new CLIMATES.BV(CLIMATES.Data.this.boosters, s.boostable, s.booster.isMul));
/*     */                 }
/* 157 */                 ((CLIMATES.BV)CLIMATES.Data.this.bvmap.get(k)).set(c, s.booster.to());
/*     */               } 
/*     */             } 
/*     */           }
/*     */         };
/*     */       
/* 163 */       BOOSTING.connecter(a);
/*     */       
/* 165 */       for (CLIMATE c : this.all) {
/* 166 */         GVALUES.FACTION.push("CLIMATE_" + c.key, String.valueOf(this.info.name) + ": " + String.valueOf(this.info.name), (SPRITE)(UI.icons()).s.heat, new BOOLEANO<Faction>()
/*     */             {
/*     */               public boolean is(Faction t)
/*     */               {
/* 170 */                 if (t.capitolRegion() != null)
/* 171 */                   return ((WORLD.CLIMATE()).getter.get(t.capitolRegion().cx(), t.capitolRegion().cy()) == c); 
/* 172 */                 return false;
/*     */               }
/*     */             });
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class BV
/*     */     extends Booster
/*     */   {
/*     */     private double from;
/*     */     
/*     */     private double to;
/*     */     
/* 188 */     private final double[] values = new double[CLIMATES.ALL().size()];
/*     */     private final boolean isMul;
/*     */     public final BoostSpec spec;
/*     */     private final BValue value;
/*     */     
/*     */     BV(BoostSpecs bos, Boostable target, boolean isMul) {
/* 194 */       super(new BSourceInfo((CLIMATES.INFO()).name, (SPRITE)(UI.icons()).s.heat), isMul);
/* 195 */       this.isMul = isMul;
/* 196 */       if (isMul)
/* 197 */         Arrays.fill(this.values, 1.0D); 
/* 198 */       set();
/* 199 */       this.spec = bos.push(this, target);
/* 200 */       this.value = new BValue()
/*     */         {
/*     */           public double vGet(Region reg)
/*     */           {
/* 204 */             if (reg == null)
/* 205 */               return 0.0D; 
/* 206 */             double res = 0.0D;
/* 207 */             for (int ci = 0; ci < CLIMATES.ALL().size(); ci++) {
/* 208 */               res += CLIMATES.BV.this.values[ci] * reg.info.climate((CLIMATE)CLIMATES.ALL().get(ci));
/*     */             }
/*     */             
/* 211 */             return res;
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(Faction f) {
/* 216 */             if (f == null)
/* 217 */               return 0.0D; 
/* 218 */             return super.vGet(f);
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(Induvidual indu) {
/* 223 */             return vGet(indu.faction());
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(Div div) {
/* 228 */             return vGet(div.faction());
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(HCLASS_RACE popTime) {
/* 233 */             if (FACTIONS.player() == null)
/* 234 */               return 0.0D; 
/* 235 */             return vGet(FACTIONS.player());
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(Player f) {
/* 240 */             if (f.capitolRegion() == null)
/* 241 */               return 0.0D; 
/* 242 */             return CLIMATES.BV.this.values[((CLIMATE)(WORLD.CLIMATE()).getter.get(f.capitolRegion().cx(), f.capitolRegion().cy())).index()];
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(FactionNPC f) {
/* 247 */             return vGet(f.capitolRegion());
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     void set(CLIMATE c, double value) {
/* 253 */       this.values[c.index()] = value;
/* 254 */       set();
/*     */     }
/*     */     
/*     */     private void set() {
/* 258 */       if (this.isMul) {
/* 259 */         this.from = 1.0D;
/* 260 */         this.to = 1.0D;
/*     */       } else {
/* 262 */         this.from = 0.0D;
/* 263 */         this.to = 0.0D;
/*     */       }  byte b; int i;
/*     */       double[] arrayOfDouble;
/* 266 */       for (i = (arrayOfDouble = this.values).length, b = 0; b < i; ) { double v = arrayOfDouble[b];
/*     */         
/* 268 */         this.from = Math.min(v, this.from);
/* 269 */         this.to = Math.max(v, this.to);
/*     */         b++; }
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double from() {
/* 279 */       return this.from;
/*     */     }
/*     */ 
/*     */     
/*     */     public double to() {
/* 284 */       return this.to;
/*     */     }
/*     */ 
/*     */     
/*     */     public double getValue(double input) {
/* 289 */       return input;
/*     */     }
/*     */ 
/*     */     
/*     */     protected double pget(BOOSTABLE_O o) {
/* 294 */       return o.boostableValue(this.value);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\CLIMATES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */