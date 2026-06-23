/*     */ package settlement.room.main;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import java.util.Arrays;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RoomUpgrades
/*     */ {
/*     */   private final int upgrades;
/*     */   private final double[][] masks;
/*     */   private final double[] boosts;
/*  39 */   public final ArrayListGrower<Lockable<Faction>> reqs = new ArrayListGrower();
/*     */   private final CharSequence[] texts;
/*  41 */   private static final COLOR ORANGE100 = (COLOR)new ColorImp(127, 100, 0);
/*     */   
/*     */   RoomUpgrades(final RoomBlueprintImp blue, RoomInitData init) {
/*  44 */     double ai = 0.0D;
/*  45 */     if (init.data().has("UPGRADES")) {
/*  46 */       Json[] jj = init.data().jsons("UPGRADES", 1);
/*  47 */       this.masks = new double[jj.length][];
/*  48 */       this.boosts = new double[jj.length];
/*     */       
/*  50 */       this.upgrades = jj.length;
/*  51 */       int j = 0;
/*  52 */       int ll = 0; byte b; int k; Json[] arrayOfJson1;
/*  53 */       for (k = (arrayOfJson1 = jj).length, b = 0; b < k; ) { Json json = arrayOfJson1[b];
/*  54 */         double[] mask = json.ds("RESOURCE_MASK");
/*     */         
/*  56 */         ll = Math.max(ll, mask.length);
/*  57 */         double d = json.d("BOOST");
/*  58 */         this.masks[j] = mask;
/*     */ 
/*     */         
/*  61 */         this.boosts[j] = d;
/*  62 */         if (json.has("AI")) {
/*  63 */           ai = Math.max(ai, json.d("AI", 0.0D, 10000.0D));
/*     */         } else {
/*  65 */           ai = Math.max(ai, d * 0.5D);
/*     */         } 
/*     */         
/*  68 */         j++;
/*     */         
/*     */         b++; }
/*     */       
/*  72 */       for (j = 0; j < this.boosts.length; j++) {
/*  73 */         if ((this.masks[j]).length < ll) {
/*  74 */           double[] nn = new double[ll];
/*  75 */           Arrays.fill(nn, 1.0D);
/*  76 */           for (int m = 0; m < (this.masks[j]).length; m++)
/*  77 */             nn[m] = this.masks[j][m]; 
/*  78 */           this.masks[j] = nn;
/*     */         } 
/*     */       } 
/*  81 */       this.texts = (CharSequence[])init.text().textsTry("UPGRADES");
/*     */     }
/*     */     else {
/*     */       
/*  85 */       this.upgrades = 1;
/*  86 */       this.masks = new double[][] {
/*  87 */           { 1.0D }
/*     */         };
/*  89 */       this.boosts = new double[] {
/*  90 */           1.0D
/*     */         };
/*  92 */       this.texts = new CharSequence[0];
/*     */     } 
/*     */     
/*  95 */     for (int i = 1; i <= max(); i++) {
/*     */       
/*  97 */       final int upAm = i;
/*     */ 
/*     */       
/* 100 */       SPRITE.Imp imp = new SPRITE.Imp(32, 32)
/*     */         {
/*     */ 
/*     */           
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 106 */             blue.icon.render(r, X1, X2, Y1, Y2);
/* 107 */             int size = 16 * (X2 - X1) / 32;
/*     */             
/* 109 */             (UI.icons()).s.chevron(DIR.N);
/*     */             
/* 111 */             COLOR.BLACK.bind();
/* 112 */             OPACITY.O66.bind();
/* 113 */             int sh = size / 8; int j;
/* 114 */             for (j = 0; j < upAm; j++)
/* 115 */               (UI.icons()).s.chevron(DIR.N).render(r, X1 + sh, X1 + size + sh, Y1 + sh + j * size / 2, Y1 + sh + j * size / 2 + size); 
/* 116 */             OPACITY.unbind();
/* 117 */             COLOR.unbind();
/*     */ 
/*     */             
/* 120 */             RoomUpgrades.ORANGE100.bind();
/* 121 */             for (j = 0; j < upAm; j++)
/* 122 */               (UI.icons()).s.chevron(DIR.N).render(r, X1, X1 + size, Y1 + j * size / 2, Y1 + j * size / 2 + size); 
/* 123 */             COLOR.unbind();
/* 124 */             COLOR.unbind();
/* 125 */             size = 24 * (X2 - X1) / 64;
/*     */             
/* 127 */             for (int ri = 0; ri < blue.constructor().resources(); ri++) {
/* 128 */               if (RoomUpgrades.this.masks[upAm][ri] > 0.0D && RoomUpgrades.this.masks[upAm - 1][ri] == 0.0D) {
/* 129 */                 blue.constructor().resource(ri).icon().render(r, X2 - size, X2, Y2 - size, Y2);
/* 130 */                 Y2 = (int)(Y2 - size * 0.75D);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/* 138 */       this.reqs.add(GVALUES.FACTION.LOCK.push("ROOM_" + init.key() + "_UPGRADE_" + i, String.valueOf(blue.info.name) + " (" + String.valueOf(blue.info.name) + " " + String.valueOf(Dic.¤¤Upgrade) + ")", "", (SPRITE)imp));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void pushBonus(final RoomBlueprintIns<?> blue, Boostable bo) {
/* 144 */     if (max() <= 0) {
/*     */       return;
/*     */     }
/* 147 */     double from = boost(0);
/* 148 */     double to = boost(max());
/* 149 */     BSourceInfo in = new BSourceInfo(Dic.¤¤Upgrade, (SPRITE)(UI.icons()).s.chevron(DIR.N));
/* 150 */     BoosterImp boosterImp = new BoosterImp(in, from, to, false)
/*     */       {
/*     */         public double get(BOOSTABLE_O o)
/*     */         {
/* 154 */           if (o instanceof FactionNPC) {
/* 155 */             return 0.0D;
/*     */           }
/* 157 */           return o.boostableValue((BValue)this);
/*     */         }
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
/*     */         public double vGet(Induvidual indu) {
/* 171 */           return get((RoomInstance)(STATS.WORK()).EMPLOYED.get(indu));
/*     */         }
/*     */         
/* 174 */         private int ci = -120;
/* 175 */         private double c = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public double vGet(Player f) {
/* 181 */           return vGet(HCLASS_RACE.clP());
/*     */         }
/*     */         
/*     */         private double get(RoomInstance ins) {
/* 185 */           if (ins != null && ins.blueprint() == blue) {
/* 186 */             return ins.blueprintI().upgrades().boost(ins.upgrade());
/*     */           }
/* 188 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(HCLASS_RACE popTime) {
/* 193 */           if (Math.abs(GAME.updateI() - this.ci) >= 120) {
/* 194 */             this.ci = GAME.updateI();
/* 195 */             this.c = 0.0D;
/* 196 */             int am = 0;
/* 197 */             for (int i = 0; i < blue.instancesSize(); i++) {
/* 198 */               RoomInstance ins = blue.getInstance(i);
/* 199 */               int e = ins.employees().employed();
/* 200 */               this.c += e * get(ins);
/* 201 */               am += e;
/*     */             } 
/*     */             
/* 204 */             if (am != 0) {
/* 205 */               this.c /= am;
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/* 210 */           return this.c;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public double vGet(FactionNPC f) {
/* 219 */           return 0.0D;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public double vGet(Faction f) {
/* 225 */           return 0.0D;
/*     */         }
/*     */       };
/*     */     
/* 229 */     boosterImp.add(bo);
/*     */   }
/*     */   
/*     */   public int max() {
/* 233 */     return this.upgrades - 1;
/*     */   }
/*     */   
/*     */   public double resMask(int upgrade, int ri) {
/* 237 */     upgrade = CLAMP.i(upgrade, 0, max());
/* 238 */     ri = CLAMP.i(ri, 0, (this.masks[upgrade]).length - 1);
/* 239 */     return this.masks[upgrade][ri];
/*     */   }
/*     */   
/*     */   public double boost(int upgrade) {
/* 243 */     return this.boosts[CLAMP.i(upgrade, 0, this.boosts.length - 1)];
/*     */   }
/*     */   
/*     */   public double upD(RoomInstance room) {
/* 247 */     return (1.0D + room.upgrade()) / (max() + 1.0D);
/*     */   }
/*     */   
/*     */   public Lockable<Faction> requires(int upgrade) {
/* 251 */     return (Lockable<Faction>)this.reqs.get(upgrade - 1);
/*     */   }
/*     */   
/*     */   public CharSequence desc(int upgrade) {
/* 255 */     if (upgrade > 0 && upgrade - 1 < this.texts.length) {
/* 256 */       return this.texts[upgrade - 1];
/*     */     }
/* 258 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\RoomUpgrades.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */