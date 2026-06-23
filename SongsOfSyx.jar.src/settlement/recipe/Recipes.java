/*     */ package settlement.recipe;
/*     */ 
/*     */ import game.VERSION;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ public class Recipes
/*     */   extends SETT.SettResource
/*     */ {
/*     */   private final LIST<Recipe> all;
/*  29 */   private final Li[] map = new Li[TR.ALL().size()];
/*  30 */   private static CharSequence ¤¤sname = "Captives";
/*  31 */   private static CharSequence ¤¤sdesc = "Ability to produce captive";
/*  32 */   static CharSequence ¤¤realm = "Realm";
/*  33 */   static CharSequence ¤¤faction = "Faction";
/*     */ 
/*     */   
/*  36 */   public final BoostableCat boostsSlave = new BoostableCat("SLAVE_PRODUCTION_", ¤¤sname, ¤¤sdesc, 2, (SPRITE)(UI.icons()).m.slave);
/*     */   
/*  38 */   private final ArrayListGrower<FBoost> fboosts = new ArrayListGrower();
/*     */   
/*     */   static {
/*  41 */     D.ts(Recipes.class);
/*     */   }
/*     */   
/*     */   public final RecipeRates rates;
/*     */   public final RecipeRatesVanilla ratesV;
/*     */   public final RecipeRatesPlayer player;
/*     */   
/*     */   public Recipes() {
/*  49 */     super("RECIPES", false);
/*     */ 
/*     */     
/*  52 */     this.all = Creator.all(this.boostsSlave, ¤¤sname, ¤¤sdesc, this.fboosts);
/*     */     
/*  54 */     for (int i = 0; i < this.map.length; i++) {
/*  55 */       this.map[i] = new Li();
/*     */     }
/*     */     
/*  58 */     for (Recipe fi : this.all) {
/*  59 */       this.map[fi.out.index()].add(fi);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     ArrayListGrower<ArrayListGrower<RoomBlueprintImp>> iiis = new ArrayListGrower();
/*  66 */     for (RESOURCE res : RESOURCES.ALL()) {
/*  67 */       iiis.add(new ArrayListGrower());
/*     */     }
/*  69 */     for (Industry ins : (SETT.ROOMS()).industries.all) {
/*     */       
/*  71 */       for (IndustryResource ii : ins.ins()) {
/*  72 */         RESOURCE res = ii.resource;
/*  73 */         if (((ArrayListGrower)iiis.get(res.index())).contains(ins.blue))
/*     */           continue; 
/*  75 */         ((ArrayListGrower)iiis.get(res.index())).add(ins.blue);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  80 */     this.rates = new RecipeRates(this);
/*  81 */     this.ratesV = new RecipeRatesVanilla(this);
/*  82 */     this.player = new RecipeRatesPlayer(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  87 */     file.i(this.fboosts.size());
/*  88 */     for (FBoost b : this.fboosts)
/*  89 */       file.d(b.mul); 
/*  90 */     this.player.saver.save(file);
/*  91 */     super.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  96 */     clear();
/*  97 */     int am = file.i();
/*  98 */     for (int i = 0; i < am && i < this.fboosts.size(); i++)
/*  99 */       ((FBoost)this.fboosts.get(i)).mul = file.d(); 
/* 100 */     if (!VERSION.versionIsBefore(71, 14))
/* 101 */       this.player.saver.load(file); 
/* 102 */     super.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 107 */     for (FBoost b : this.fboosts)
/* 108 */       b.randomize(); 
/*     */   }
/*     */   
/*     */   public LIST<Recipe> all() {
/* 112 */     return this.all;
/*     */   }
/*     */   
/*     */   public LIST<Recipe> get(TRADABLE t) {
/* 116 */     return (LIST<Recipe>)this.map[t.index()];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Li
/*     */     extends ArrayListGrower<Recipe>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void randomizeAIBoosts() {
/* 134 */     for (FactionNPC f : FACTIONS.NPCs()) {
/* 135 */       f.bonus.randomize();
/*     */     }
/* 137 */     for (FBoost b : this.fboosts)
/* 138 */       b.randomize(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\recipe\Recipes.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */