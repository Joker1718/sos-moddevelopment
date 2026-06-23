/*     */ package init.resources;
/*     */ 
/*     */ import init.INIT;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.keymap.RMAP;
/*     */ import util.keymap.RMAPS;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RESOURCES
/*     */   extends INIT.InitResource
/*     */ {
/*     */   private static Data data;
/*     */   public static final String KEY = "RESOURCE";
/*     */   public static final String KEYS = "RESOURCES";
/*  27 */   private static CharSequence ¤¤helpStone = "Stone can be obtained by manually clearing rocks on the ground.";
/*  28 */   private static CharSequence ¤¤helpWood = "Wood can be obtained by manually clearing trees.";
/*  29 */   private static CharSequence ¤¤helpGrow = "This crop might be growing in the wild. Have a look, maybe you can harvest some manually.";
/*     */   
/*     */   static {
/*  32 */     D.ts(RESOURCES.class);
/*     */   }
/*     */   
/*     */   private static final class Data
/*     */   {
/*     */     private final LIST<RESOURCE> all;
/*     */     private final RMAPS<RESOURCE> map;
/*     */     private final RMAP<Minable> minable;
/*     */     private final ResGroup<ResGDrink> drinks;
/*     */     private final Growable.GrowableGroup growable;
/*     */     private final ResGroup<ResGEat> edibles;
/*     */     private final RESOURCE STONE;
/*     */     private final RESOURCE WOOD;
/*     */     private final RESOURCE LIFESTOCK;
/*     */     private final int catAmount;
/*     */     private final ResSupplies supplies;
/*     */     
/*     */     Data() throws IOException {
/*  50 */       RESOURCES.data = this;
/*     */       
/*  52 */       PATH gInit = PATHS.INIT().getFolder("resource");
/*  53 */       PATH gText = PATHS.TEXT().getFolder("resource");
/*  54 */       PATH gSprite = PATHS.SPRITE().getFolder("resource");
/*  55 */       PATH gDebris = gSprite.getFolder("debris");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  60 */       String[] fixed = {
/*  61 */           "_STONE", 
/*  62 */           "_WOOD", 
/*  63 */           "_LIVESTOCK"
/*     */         };
/*  65 */       String[] mod = gInit.getFiles();
/*  66 */       String[] files = new String[fixed.length + mod.length]; int i;
/*  67 */       for (i = 0; i < fixed.length; i++)
/*  68 */         files[i] = fixed[i]; 
/*  69 */       for (i = 0; i < mod.length; i++) {
/*  70 */         files[i + fixed.length] = mod[i];
/*     */       }
/*     */       
/*  73 */       String[][] resources = new String[10][64];
/*  74 */       int[] catI = Alloc.ii(10);
/*  75 */       boolean[] categories = new boolean[10];
/*  76 */       int cats = 0; byte b2; int k;
/*     */       String[] arrayOfString2;
/*  78 */       for (k = (arrayOfString2 = files).length, b2 = 0; b2 < k; ) { String s = arrayOfString2[b2];
/*  79 */         Json in = new Json(gInit.gets(s));
/*  80 */         int c = in.i("CATEGORY_DEFAULT", 0, 10);
/*  81 */         resources[c][catI[c]] = s;
/*  82 */         catI[c] = catI[c] + 1;
/*  83 */         if (!categories[c]) {
/*  84 */           cats++;
/*  85 */           categories[c] = true;
/*     */         } 
/*     */         b2++; }
/*     */       
/*  89 */       this.catAmount = cats;
/*     */       
/*  91 */       int q = 0;
/*  92 */       for (int j = 0; j < resources.length; j++) {
/*  93 */         for (int m = 0; m < catI[j]; m++) {
/*  94 */           files[q++] = resources[j][m];
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 104 */       ArrayList<RESOURCE> all = new ArrayList(128);
/* 105 */       KeyMap<Sprite> spriteMap = new KeyMap();
/* 106 */       KeyMap<TILE_SHEET> debrisMap = new KeyMap();
/*     */       
/*     */       byte b1;
/*     */       
/*     */       String[] arrayOfString1;
/*     */       
/* 112 */       for (cats = (arrayOfString1 = files).length, b1 = 0; b1 < cats; ) { String key = arrayOfString1[b1]; b1++; }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 117 */       this.all = (LIST<RESOURCE>)new ArrayList((Iterable)all);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 122 */       this.map = new RMAPS("RESOURCE", this.all);
/*     */ 
/*     */ 
/*     */       
/* 126 */       this.STONE = (RESOURCE)this.map.get("_STONE", null);
/* 127 */       this.WOOD = (RESOURCE)this.map.get("_WOOD", null);
/* 128 */       this.LIFESTOCK = (RESOURCE)this.map.get("_LIVESTOCK", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       this.minable = Minable.make(gInit, gSprite);
/* 135 */       this.growable = Growable.make(gInit, gSprite);
/* 136 */       this.drinks = ResGDrink.make(gInit);
/* 137 */       this.edibles = ResGEat.make(gInit);
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
/* 158 */       this.supplies = new ResSupplies();
/*     */       
/* 160 */       this.STONE.specialHelpText = RESOURCES.¤¤helpStone;
/* 161 */       this.WOOD.specialHelpText = RESOURCES.¤¤helpWood;
/* 162 */       for (Growable g : this.growable.all()) {
/* 163 */         g.resource.specialHelpText = RESOURCES.¤¤helpGrow;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCES(INIT init) throws IOException {
/* 173 */     super(init);
/*     */   }
/*     */ 
/*     */   
/*     */   public static LIST<RESOURCE> ALL() {
/* 178 */     return data.all;
/*     */   }
/*     */   
/*     */   public static RMAP<Minable> minables() {
/* 182 */     return data.minable;
/*     */   }
/*     */   
/*     */   public static Growable.GrowableGroup growable() {
/* 186 */     return data.growable;
/*     */   }
/*     */   
/*     */   public static ResGroup<ResGDrink> DRINKS() {
/* 190 */     return data.drinks;
/*     */   }
/*     */   
/*     */   public static ResGroup<ResGEat> EDI() {
/* 194 */     return data.edibles;
/*     */   }
/*     */   
/*     */   public static RESOURCE STONE() {
/* 198 */     return data.STONE;
/*     */   }
/*     */   
/*     */   public static RESOURCE WOOD() {
/* 202 */     return data.WOOD;
/*     */   }
/*     */   
/*     */   public static RESOURCE LIVESTOCK() {
/* 206 */     return data.LIFESTOCK;
/*     */   }
/*     */   
/*     */   public static int CATEGORIES() {
/* 210 */     return data.catAmount;
/*     */   }
/*     */   
/*     */   public static ResSupplies SUP() {
/* 214 */     return data.supplies;
/*     */   }
/*     */   
/*     */   public static RMAPS<RESOURCE> map() {
/* 218 */     return data.map;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\RESOURCES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */