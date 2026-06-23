/*     */ package settlement.stats.equip;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import init.paths.PATH;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.thing.projectiles.Projectile;
/*     */ import settlement.thing.projectiles.SProjectiles;
/*     */ import settlement.thing.projectiles.Trajectory;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import util.updating.IUpdater;
/*     */ 
/*     */ public class EquipRange
/*     */   extends EquipBattle {
/*     */   public final Projectile projectile;
/*     */   public final int ammoMax;
/*     */   public final double ammoReplenishHours;
/*     */   public final short tIndex;
/*  49 */   private final double[] drawInters = new double[(Config.battle()).DIVISIONS_PER_BATTLE];
/*  50 */   private final int[] drawIntersI = Alloc.ii((Config.battle()).DIVISIONS_PER_BATTLE);
/*  51 */   private final double[] ammoWasted = new double[(Config.battle()).DIVISIONS_PER_BATTLE];
/*     */   
/*     */   public final Boostable boostable;
/*  54 */   private static CharSequence ¤¤ammoC = "Ammunition (Current)";
/*  55 */   private static CharSequence ¤¤ammoR = "Am. Replenish Time (hours)";
/*  56 */   private static CharSequence ¤¤ammoU = "Unlimited ammunition!";
/*     */   
/*     */   static {
/*  59 */     D.ts(EquipRange.class);
/*     */   }
/*     */ 
/*     */   
/*     */   EquipRange(String key, PATH path, LISTE<Equip> all, LISTE<EquipRange> type, LISTE<EquipBattle> mil, StatsInit init, KeyMap<TILE_SHEET> spriteMap) throws IOException {
/*  64 */     super("RANGED", key, path, all, mil, init, spriteMap);
/*  65 */     this.tIndex = (short)type.add(this);
/*  66 */     Json data = new Json(path.gets(key));
/*     */     
/*  68 */     this.ammoMax = data.i("AMMUNITION_AMOUNT", 1, 255);
/*  69 */     this.ammoReplenishHours = data.d("AMMUNITION_REPLENISH_TIME_HOURS");
/*     */ 
/*     */     
/*  72 */     this.boostable = BOOSTING.push("RANGED_" + key, 0.1D, String.valueOf(Dic.¤¤Skill) + ": " + String.valueOf(Dic.¤¤Skill), 
/*  73 */         String.valueOf(Dic.¤¤Skill) + ": " + String.valueOf(Dic.¤¤Skill), (SPRITE)this.resource.icon(), (BoostableCat)BOOSTABLES.BATTLE());
/*  74 */     this.projectile = (Projectile)new Projectile.ProjectileImp(data, "EQUIP_" + key);
/*     */     
/*  76 */     final IUpdater up = new IUpdater((Config.battle()).DIVISIONS_PER_BATTLE, 10.0D)
/*     */       {
/*     */         protected void update(int i, double timeSinceLast)
/*     */         {
/*  80 */           Div d = GAME.ARMIES().division((short)i);
/*  81 */           if (d.menNrOf() == 0) {
/*  82 */             EquipRange.this.ammoWasted[i] = 0.0D;
/*     */             
/*     */             return;
/*     */           } 
/*  86 */           int men = d.men();
/*     */           
/*  88 */           int m = men * EquipRange.this.ammoMax;
/*  89 */           if (EquipRange.this.ammoWasted[i] > m) {
/*  90 */             EquipRange.this.ammoWasted[i] = m;
/*     */           }
/*     */           
/*  93 */           if (d.player() && GAME.ARMIES().enemy().men() == 0) {
/*  94 */             EquipRange.this.ammoWasted[i] = EquipRange.this.ammoWasted[i] - men * timeSinceLast * TIME.secondsPerDayI() * TIME.hoursPerDay() / EquipRange.this.ammoReplenishHours;
/*  95 */             if (EquipRange.this.ammoWasted[i] < 0.0D) {
/*  96 */               EquipRange.this.ammoWasted[i] = 0.0D;
/*     */             }
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 102 */     init.upers.add(new StatsInit.StatUpdatable()
/*     */         {
/*     */           public void update(double ds)
/*     */           {
/* 106 */             up.update(ds);
/*     */           }
/*     */         });
/*     */     
/* 110 */     init.savers.put("EQUIP_AMMO_" + key, new SAVABLE()
/*     */         {
/*     */           public void save(FilePutter file)
/*     */           {
/* 114 */             up.save(file);
/* 115 */             file.ds(EquipRange.this.ammoWasted);
/*     */           }
/*     */ 
/*     */           
/*     */           public void load(FileGetter file) throws IOException {
/* 120 */             up.load(file);
/* 121 */             file.ds(EquipRange.this.ammoWasted);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void clear() {
/* 127 */             up.clear();
/* 128 */             Arrays.fill(EquipRange.this.ammoWasted, 0.0D);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double ammoD(Div div) {
/* 138 */     if (div.men() == 0)
/* 139 */       return 0.0D; 
/* 140 */     double m = (div.men() * this.ammoMax);
/* 141 */     double a = this.ammoWasted[div.index()];
/* 142 */     if (a > m)
/* 143 */       a = m; 
/* 144 */     return (m - a) / m;
/*     */   }
/*     */   
/*     */   public double ammoPerMan(Div div) {
/* 148 */     return ammoD(div) * this.ammoMax;
/*     */   }
/*     */   
/*     */   public void ammoClear(Div div) {
/* 152 */     this.ammoWasted[div.index()] = 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double ref(Induvidual a) {
/* 157 */     return ref(get(a) / this.equipMax, this.boostable.get((BOOSTABLE_O)a));
/*     */   }
/*     */   
/*     */   public double ref(Div div) {
/* 161 */     return ref(this.stat.div().getD(div), this.boostable.get((BOOSTABLE_O)div));
/*     */   }
/*     */   
/*     */   public double ref(double equip, double skill) {
/* 165 */     return equip * (0.2D + equip * 0.8D) * skill;
/*     */   }
/*     */   
/*     */   public void launch(Humanoid a, Trajectory j) {
/* 169 */     double ref = ref(a.indu());
/* 170 */     double ran = 1.0D - this.projectile.accuracy(ref);
/* 171 */     int x = a.body().cX() + a.speed.dir().x() * 32;
/* 172 */     int y = a.body().cY() + a.speed.dir().y() * 32;
/* 173 */     int h = SProjectiles.releaseHeight(a.tc().x(), a.tc().y());
/* 174 */     SETT.PROJS().launch(x, y, h, j, (a.division().settings().ammo()).projectile, ran, ref, (ENTITY)a);
/*     */     
/* 176 */     if (this.ammoReplenishHours > 0.0D) {
/* 177 */       this.ammoWasted[a.division().index()] = this.ammoWasted[a.division().index()] + 1.0D;
/*     */     }
/* 179 */     double dex = 2.0D * (STATS.NEEDS()).EXHASTION.indu().max(a.indu()) / this.ammoMax;
/* 180 */     int ex = (int)dex;
/* 181 */     if (dex - ex > RND.rFloat())
/* 182 */       ex++; 
/* 183 */     (STATS.NEEDS()).EXHASTION.indu().inc(a.indu(), ex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double drawInter(Div div) {
/* 191 */     if ((GAME.updateI() & 0xFFFFFFFC) != this.drawIntersI[div.index()]) {
/* 192 */       double reloadSeconds = this.projectile.reloadSeconds(ref(div));
/* 193 */       double t = TIME.currentSecond();
/* 194 */       double inter = reloadSeconds;
/*     */       
/* 196 */       double tt = t / inter;
/* 197 */       this.drawInters[div.index()] = tt - (int)tt;
/*     */       
/* 199 */       this.drawIntersI[div.index()] = GAME.updateI() & 0xFFFFFFFC;
/*     */     } 
/*     */     
/* 202 */     return this.drawInters[div.index()];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box) {
/* 208 */     super.hover(box);
/* 209 */     GBox b = (GBox)box;
/* 210 */     b.sep();
/* 211 */     this.projectile.hover(box, this.resource.name);
/* 212 */     b.NL(8);
/* 213 */     if (this.ammoReplenishHours > 0.0D) {
/* 214 */       b.textL(Dic.¤¤Ammunition);
/* 215 */       b.tab(6);
/* 216 */       b.add((SPRITE)GFORMAT.i(b.text(), this.ammoMax));
/* 217 */       b.tab(8);
/* 218 */       b.add((SPRITE)(UI.icons()).s.clock);
/* 219 */       b.add((SPRITE)GFORMAT.f(b.text(), this.ammoReplenishHours));
/* 220 */       b.text(DicTime.¤¤Hours);
/*     */     } 
/* 222 */     b.NL(8);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void hover(GUI_BOX box, double ref, double ammo) {
/* 228 */     GBox b = (GBox)box;
/* 229 */     b.sep();
/* 230 */     this.projectile.hover(box, this.resource.name, ref, 0);
/* 231 */     b.NL(8);
/*     */ 
/*     */ 
/*     */     
/* 235 */     b.sep();
/*     */     
/* 237 */     if (this.ammoReplenishHours > 0.0D) {
/*     */       
/* 239 */       b.textLL(¤¤ammoC);
/* 240 */       b.tab(7);
/* 241 */       b.add((SPRITE)GFORMAT.fofkInv(b.text(), ammo, this.ammoMax));
/* 242 */       b.NL();
/*     */       
/* 244 */       b.textL(¤¤ammoR);
/* 245 */       b.tab(7);
/* 246 */       b.add((SPRITE)GFORMAT.f(b.text(), this.ammoReplenishHours));
/*     */     } else {
/*     */       
/* 249 */       b.textLL(¤¤ammoU);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box, Div div) {
/* 255 */     super.hover(box, div);
/* 256 */     hover(box, ref(div), ammoPerMan(div));
/* 257 */     box.NL();
/* 258 */     this.boostable.hoverDetailed(box, (BOOSTABLE_O)div, "", true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box, Induvidual i) {
/* 263 */     super.hover(box, i);
/* 264 */     hover(box, ref(i), this.ammoMax);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\equip\EquipRange.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */