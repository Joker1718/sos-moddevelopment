/*     */ package settlement.stats.equip;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.race.RACES;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.entity.animal.AnimalSpecies;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import util.text.D;
/*     */ 
/*     */ public class EquipBattle
/*     */   extends Equip
/*     */ {
/*  41 */   private final Bitsmap1D tars = new Bitsmap1D(0, 8, 2 * (Config.battle()).DIVISIONS_PER_ARMY);
/*     */   
/*     */   private final int iMil;
/*     */   public final int amountInGarrison;
/*     */   public final double[] slotUse;
/*  46 */   public final DivSprite[] sprites = new DivSprite[RACES.all().size()];
/*  47 */   public static CharSequence ¤¤combineProblem = "Can not be combined with current equipment.";
/*  48 */   public static CharSequence ¤¤raceProblem = "This equipment is not applicable for the selected race.";
/*     */   public final HumanSprite sprite;
/*     */   public final AnimalSpecies mount;
/*     */   public final int formationAdd;
/*     */   public static final int SLOTS = 8;
/*     */   
/*     */   static {
/*  55 */     D.ts(EquipBattle.class);
/*     */   }
/*     */ 
/*     */   
/*     */   EquipBattle(String coll, String key, PATH path, LISTE<Equip> all, LISTE<EquipBattle> mil, StatsInit init, KeyMap<TILE_SHEET> spriteMap) throws IOException {
/*  60 */     super(coll, key, path, all, init);
/*     */     
/*  62 */     this.iMil = mil.add(this);
/*     */     
/*  64 */     Json j = new Json(path.gets(key));
/*  65 */     if (RESOURCES.SUP().get(this.resource) != null)
/*  66 */       j.error("Can not have an equippable that is also a regular army supply!", this.resource.key); 
/*  67 */     this.amountInGarrison = j.i("AMOUNT_IN_GARRISON", 0, this.equipMax);
/*  68 */     init.savers.put(coll + "_" + coll + "_tars", this.tars);
/*  69 */     this.slotUse = j.ds("SLOT_USAGE", 8);
/*  70 */     this.stat.info().setMatters(false, true);
/*     */     
/*  72 */     for (int i = 0; i < this.sprites.length; i++) {
/*  73 */       this.sprites[i] = new DivSprite();
/*  74 */       this.sprites[i].read(j.json("DIV_SPRITE"));
/*     */     } 
/*     */     
/*  77 */     if (j.has("SPRITE")) {
/*  78 */       this.sprite = new HumanSprite(j, spriteMap);
/*     */     } else {
/*  80 */       this.sprite = null;
/*  81 */     }  if (j.has("MOUNTED_ANIMAL")) {
/*  82 */       this.mount = (AnimalSpecies)(SETT.ANIMALS()).map.read("MOUNTED_ANIMAL", j);
/*     */     } else {
/*  84 */       this.mount = null;
/*     */     } 
/*  86 */     this.formationAdd = j.i("ADD_TO_FORMATION_SIZE", 0, 100, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int target(Induvidual h) {
/*  94 */     Div i = (Div)(STATS.BATTLE()).DIV.get(h);
/*  95 */     if (i != null && (
/*  96 */       (SETT.ROOMS()).GUARD.activeDuty.is(i) || i.settings().mustering())) {
/*  97 */       return target(i);
/*     */     }
/*     */     
/* 100 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double bValue(double equipped) {
/* 106 */     equipped = CLAMP.d(equipped, 0.0D, 1.0D);
/* 107 */     return equipped;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(Induvidual i) {
/* 112 */     return this.equipMax;
/*     */   }
/*     */   
/*     */   public int target(Div d) {
/* 116 */     return CLAMP.i(this.tars.get(d.index()), 0, this.equipMax);
/*     */   }
/*     */   
/*     */   public void targetSet(Div d, int t) {
/* 120 */     this.tars.set(d.index(), CLAMP.i(t, 0, this.equipMax));
/*     */   }
/*     */   
/*     */   public int max() {
/* 124 */     return this.equipMax;
/*     */   }
/*     */   
/*     */   public int indexMilitary() {
/* 128 */     return this.iMil;
/*     */   }
/*     */   
/*     */   public int garrisonAmount() {
/* 132 */     return this.amountInGarrison;
/*     */   }
/*     */   
/*     */   public double slotUse(int slot) {
/* 136 */     return this.slotUse[slot];
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverP(GUI_BOX box) {
/* 141 */     super.hoverP(box);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class DivSprite
/*     */   {
/* 148 */     public int ox = 0;
/* 149 */     public int oy = 0;
/* 150 */     public int z = 0;
/* 151 */     public SPRITE icon = (SPRITE)(UI.icons()).s.cancel;
/* 152 */     public LIST<ColorImp> cols = (LIST<ColorImp>)new ArrayListGrower();
/*     */     
/*     */     public void read(Json json) throws IOException {
/* 155 */       this.ox = json.i("X", -100, 100, 0);
/* 156 */       this.oy = json.i("Y", -100, 100, 0);
/* 157 */       this.z = json.i("Z", -100, 100, 0);
/* 158 */       this.icon = (SPRITE)UI.icons().get(json, (Icon)(UI.icons()).s.cancel);
/* 159 */       this.cols = ColorImp.cols(json);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final class HumanSprite
/*     */   {
/*     */     public final double offsetX;
/*     */     public final double offsetY;
/*     */     public final double animationX;
/*     */     public final double animationY;
/*     */     private TILE_SHEET sheet;
/* 171 */     public LIST<ColorImp> cols = (LIST<ColorImp>)new ArrayListGrower();
/*     */     
/*     */     private HumanSprite(Json json, KeyMap<TILE_SHEET> map) throws IOException {
/* 174 */       json = json.json("SPRITE");
/*     */       
/* 176 */       this.offsetX = json.d("OFFSET_X", -100.0D, 100.0D);
/* 177 */       this.offsetY = json.d("OFFSET_Y", -100.0D, 100.0D);
/* 178 */       this.animationX = json.d("ANIMATION_DX", -100.0D, 100.0D);
/* 179 */       this.animationY = json.d("ANIMATION_DY", -100.0D, 100.0D);
/*     */       
/* 181 */       String file = json.value("FILE");
/* 182 */       if (!map.containsKey(file)) {
/*     */         
/* 184 */         TILE_SHEET sheet = (new ComposerThings.ITileSheet(PATHS.SPRITE().getFolder("race").getFolder("battle").get(file), 132, 
/* 185 */             36)
/*     */           {
/*     */             protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/* 189 */               s.singles.init(0, 0, 1, 1, 2, 1, (ComposerDests.Dest)d.s24);
/* 190 */               s.singles.setSkip(0, 2).paste(3, true);
/* 191 */               return d.s24.saveGame();
/*     */             }
/* 193 */           }).get();
/* 194 */         map.put(file, sheet);
/*     */       } 
/*     */       
/* 197 */       this.sheet = (TILE_SHEET)map.get(file);
/* 198 */       this.cols = ColorImp.cols(json);
/*     */     }
/*     */     
/*     */     public void render(Induvidual a, SPRITE_RENDERER r, DIR dir, double forward, int x, int y, ShadowBatch s) {
/* 202 */       double am = EquipBattle.this.get(a);
/* 203 */       if (am == 0.0D) {
/*     */         return;
/*     */       }
/* 206 */       ColorImp.TMP.interpolate(this.cols, am / EquipBattle.this.max());
/* 207 */       ColorImp.TMP.bind();
/*     */       
/* 209 */       int t = dir.id();
/*     */       
/* 211 */       x += 48;
/* 212 */       y += 48;
/*     */ 
/*     */       
/* 215 */       double rotY = dir.xN() * this.offsetX + dir.yN() * this.offsetY;
/* 216 */       double rotX = -dir.yN() * this.offsetX + dir.xN() * this.offsetY;
/*     */       
/* 218 */       double aY = dir.xN() * this.animationX + dir.yN() * this.animationY;
/* 219 */       double aX = -dir.yN() * this.animationX + dir.xN() * this.animationY;
/*     */       
/* 221 */       int cx = (int)((rotX + aX * forward) * (a.race()).physics.hitBoxsize());
/* 222 */       int cy = (int)((rotY + aY * forward) * (a.race()).physics.hitBoxsize());
/*     */       
/* 224 */       this.sheet.renderC(r, t, x + cx, y + cy);
/* 225 */       s.setHeight(0).setDistance2Ground((a.race()).physics.height() / 2.0D);
/*     */       
/* 227 */       this.sheet.renderC((SPRITE_RENDERER)s, t, x + cx, y + cy);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\equip\EquipBattle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */