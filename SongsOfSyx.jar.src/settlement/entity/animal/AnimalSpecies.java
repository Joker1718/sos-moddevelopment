/*     */ package settlement.entity.animal;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMAP;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AnimalSpecies
/*     */   extends INFO
/*     */   implements MAPPED
/*     */ {
/*     */   public static final int SIZE = 96;
/*     */   private final double massMin;
/*     */   private final double heightOverGround;
/*     */   private final double acceleration;
/*     */   public final int hitboxSize;
/*     */   private final int spriteOff;
/*     */   public final Icon icon;
/*     */   private final int index;
/*     */   public final boolean caravanable;
/*     */   public final COLOR color;
/*     */   private final LIST<RESOURCE> resources;
/*     */   public final RBIT rBit;
/*     */   private final double[] resAmounts;
/*     */   private final double[] climates;
/*     */   private final double[] terrains;
/*     */   private final String key;
/*     */   public final double[] damage;
/*     */   public final boolean pack;
/*     */   public final boolean grazes;
/*     */   public final COLOR blood;
/*     */   public final double momTreshold;
/*     */   public final double momTresholdFly;
/*     */   public final double caveLiving;
/*     */   public final double danger;
/*     */   public final SoundRace sound;
/*     */   public final TILE_SHEET sheet;
/*     */   
/*     */   AnimalSpecies(String key, int index, Json data, Json text, KeyMap<TILE_SHEET> sprites) throws IOException {
/*  68 */     super(text, null); TILE_SHEET sheet; this.damage = new double[(BOOSTABLES.BATTLE()).DAMAGES.size()]; this.blood = (COLOR)new ColorImp(127, 15, 15);
/*  69 */     this.key = key;
/*  70 */     this.index = index;
/*  71 */     this.icon = SPRITES.icons().get(data);
/*  72 */     this.caravanable = data.bool("CARAVAN");
/*  73 */     this.massMin = data.i("MASS", 1, 500);
/*  74 */     this.acceleration = (data.i("SPEED", 1, 31) * 64);
/*  75 */     this.heightOverGround = data.i("HEIGHT", 0, 50);
/*  76 */     this.hitboxSize = 44;
/*  77 */     this.spriteOff = (128 - this.hitboxSize) / 2;
/*  78 */     this.color = (COLOR)new ColorImp(data);
/*  79 */     this.resources = RESOURCES.map().readMany(data);
/*  80 */     this.resAmounts = data.ds("RESOURCE_AMOUNT", this.resources.size());
/*     */     
/*  82 */     RBIT.RBITImp bb = new RBIT.RBITImp();
/*  83 */     for (RESOURCE res : this.resources) {
/*  84 */       bb.or(res);
/*     */     }
/*  86 */     this.rBit = (RBIT)bb;
/*     */     
/*  88 */     (BOOSTABLES.BATTLE()).DAMAGE_COLL.getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     CLIMATES.MAP();
/*  98 */     this.climates = CLIMATES.MAP().readFill(data, 1.0D);
/*  99 */     this.terrains = TERRAINS.MAP().readFill(data, 1.0D);
/* 100 */     this.pack = data.bool("PACK");
/* 101 */     this.grazes = data.bool("GRAZES");
/* 102 */     this.danger = data.d("DANGER", 0.0D, 1.0D);
/* 103 */     this.momTreshold = this.acceleration * this.massMin * 1.5D;
/* 104 */     this.momTresholdFly = this.acceleration * this.massMin * 2.0D;
/* 105 */     this.caveLiving = data.d("LIVES_IN_CAVES", 0.0D, 1.0D);
/*     */     
/* 107 */     this.sound = AUDIO.race("ANIMAL_CALL_" + key);
/* 108 */     String sKey = data.value("SPRITE");
/*     */     
/* 110 */     if (sprites.containsKey(sKey)) {
/* 111 */       sheet = (TILE_SHEET)sprites.get(sKey);
/*     */     }
/*     */     else {
/*     */       
/* 115 */       sheet = (new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 119 */             s.singles.init(0, 0, 1, 1, 2, 12, (ComposerDests.Dest)d.s32);
/* 120 */             for (int i = 0; i < 12; i++) {
/* 121 */               s.singles.setSkip(i * 2, 2).paste(3, true);
/*     */             }
/* 123 */             return d.s32.saveGame();
/*     */           }
/* 125 */         }).get();
/*     */     } 
/* 127 */     this.sheet = sheet;
/*     */   }
/*     */   
/*     */   public double occurence(CLIMATE c) {
/* 131 */     return this.climates[c.index()];
/*     */   }
/*     */   
/*     */   public double occurence(TERRAIN t) {
/* 135 */     return this.terrains[t.index()];
/*     */   }
/*     */   
/*     */   public double mass() {
/* 139 */     return this.massMin;
/*     */   }
/*     */   
/*     */   public double heightOverGround() {
/* 143 */     return this.heightOverGround;
/*     */   }
/*     */   
/*     */   public double acceleration() {
/* 147 */     return this.acceleration;
/*     */   }
/*     */   
/*     */   public int hitBoxSize() {
/* 151 */     return this.hitboxSize;
/*     */   }
/*     */   
/*     */   public int spriteOff() {
/* 155 */     return this.spriteOff;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 160 */     return this.index;
/*     */   }
/*     */   
/*     */   public LIST<RESOURCE> resources() {
/* 164 */     return this.resources;
/*     */   }
/*     */   
/*     */   public int resAmount(int ri, double weight) {
/* 168 */     return (int)Math.ceil(this.resAmounts[ri] * weight * 0.3D);
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/* 173 */     return this.key;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\AnimalSpecies.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */