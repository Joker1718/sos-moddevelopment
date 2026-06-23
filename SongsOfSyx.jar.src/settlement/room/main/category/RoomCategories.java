/*     */ package settlement.room.main.category;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class RoomCategories {
/*     */   private final ArrayListGrower<RoomCategorySub> all;
/*     */   public final RoomCategorySub MINES;
/*     */   public final RoomCategorySub REFINERS;
/*     */   public final RoomCategorySub CRAFTING;
/*     */   public final RoomCategorySub LAW;
/*     */   public final RoomCategorySub FARMS;
/*     */   public final RoomCategorySub FISH;
/*  17 */   static CharSequence ¤¤other = "¤Other"; public final RoomCategorySub HUSBANDRY; public final RoomCategorySub MILITARY; public final RoomCategorySub ADMIN; public final RoomCategorySub BREEDING; public final RoomCategorySub DECOR; public final RoomCategorySub LOGISTICS;
/*     */   
/*     */   public RoomCategories(ROOMS r) {
/*  20 */     D.t(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  27 */     this.all = new ArrayListGrower();
/*     */     
/*  29 */     this.MINES = new RoomCategorySub(this.all, D.g("Mines"), (SPRITES.icons()).l.mine, (COLOR)new ColorImp(120, 47, 0));
/*  30 */     this.REFINERS = new RoomCategorySub(this.all, D.g("Refining"), (SPRITES.icons()).l.refiner, (COLOR)new ColorImp(113, 97, 19));
/*  31 */     this.CRAFTING = new RoomCategorySub(this.all, D.g("Crafting"), (SPRITES.icons()).l.workshop, (COLOR)new ColorImp(127, 77, 19));
/*  32 */     this.LAW = new RoomCategorySub(this.all, D.g("Law"), (SPRITES.icons()).l.law, (COLOR)new ColorImp(90, 90, 90));
/*  33 */     this.FARMS = new RoomCategorySub(this.all, D.g("Farms"), (SPRITES.icons()).l.farm, (COLOR)new ColorImp(37, 59, 7));
/*  34 */     this.FISH = new RoomCategorySub(this.all, D.g("Aquaculture"), (SPRITES.icons()).l.fish, (COLOR)new ColorImp(37, 59, 7));
/*  35 */     this.HUSBANDRY = new RoomCategorySub(this.all, D.g("Husbandry"), (SPRITES.icons()).l.pasture, (COLOR)new ColorImp(37, 59, 7));
/*  36 */     this.MILITARY = new RoomCategorySub(this.all, D.g("Military"), (SPRITES.icons()).l.trainig, (COLOR)new ColorImp(127, 0, 0));
/*  37 */     this.ADMIN = new RoomCategorySub(this.all, D.g("Administration"), (SPRITES.icons()).l.admin, (COLOR)new ColorImp(0, 127, 127));
/*  38 */     this.BREEDING = new RoomCategorySub(this.all, D.g("Procreation"), (SPRITES.icons()).l.breeding, (COLOR)new ColorImp(35, 0, 127));
/*  39 */     this.DECOR = new RoomCategorySub(this.all, D.g("Decorations"), (SPRITES.icons()).l.decor, (COLOR)new ColorImp(35, 0, 127));
/*  40 */     this.LOGISTICS = new RoomCategorySub(this.all, D.g("Logistics"), (SPRITES.icons()).l.logistics, (COLOR)new ColorImp(35, 0, 127));
/*  41 */     this.WATER = new RoomCategorySub(this.all, D.g("Water"), (SPRITES.icons()).l.water, (COLOR)new ColorImp(35, 0, 127));
/*     */ 
/*     */     
/*  44 */     this.SER_REL = new RoomCategorySub(this.all, D.g("Religion"), (SPRITES.icons()).l.religion, (COLOR)new ColorImp(35, 0, 127));
/*  45 */     this.SER_CONSUMPTION = new RoomCategorySub(this.all, D.g("Distribution"), (SPRITES.icons()).l.dist, (COLOR)new ColorImp(35, 0, 127));
/*  46 */     this.SER_HEALTH = new RoomCategorySub(this.all, D.g("Health"), (SPRITES.icons()).l.health, (COLOR)new ColorImp(35, 0, 127));
/*  47 */     this.SER_ENTERTAIN = new RoomCategorySub(this.all, D.g("Entertainment"), (SPRITES.icons()).l.entertain, (COLOR)new ColorImp(35, 0, 127));
/*  48 */     this.SER_DEATH = new RoomCategorySub(this.all, D.g("Afterlife"), (SPRITES.icons()).l.death, (COLOR)new ColorImp(35, 0, 127));
/*  49 */     this.SER_HOME = new RoomCategorySub(this.all, D.g("Home"), (SPRITES.icons()).l.home, (COLOR)new ColorImp(35, 0, 127));
/*  50 */     this.ALL = (LIST<RoomCategorySub>)this.all;
/*     */ 
/*     */     
/*  53 */     this.MAIN_AGRIULTURE = new RoomCategoryMain(D.g("Agriculture"), (SPRITES.icons()).l.agri, (LIST<RoomCategorySub>)new ArrayList((Object[])new RoomCategorySub[] {
/*  54 */             this.FARMS, 
/*  55 */             this.HUSBANDRY, 
/*  56 */             this.FISH
/*     */           }));
/*     */     
/*  59 */     this.MAIN_INDUSTRY = new RoomCategoryMain(D.g("Work"), (SPRITES.icons()).l.work, (LIST<RoomCategorySub>)new ArrayList((Object[])new RoomCategorySub[] {
/*  60 */             this.MINES, 
/*  61 */             this.REFINERS, 
/*  62 */             this.CRAFTING
/*     */           }));
/*     */     
/*  65 */     this.MAIN_SERVICE = new RoomCategoryMain(D.g("Service"), (SPRITES.icons()).l.service, (LIST<RoomCategorySub>)new ArrayList((Object[])new RoomCategorySub[] {
/*  66 */             this.SER_REL, 
/*  67 */             this.SER_CONSUMPTION, 
/*  68 */             this.SER_HEALTH, 
/*  69 */             this.SER_ENTERTAIN, 
/*  70 */             this.SER_DEATH, 
/*  71 */             this.SER_HOME
/*     */           }));
/*     */ 
/*     */ 
/*     */     
/*  76 */     this.MAIN_INFRA = new RoomCategoryMain(D.g("Government"), (SPRITES.icons()).l.gov, (LIST<RoomCategorySub>)new ArrayList((Object[])new RoomCategorySub[] {
/*  77 */             this.ADMIN, 
/*  78 */             this.LAW, 
/*  79 */             this.MILITARY, 
/*  80 */             this.BREEDING, 
/*  81 */             this.LOGISTICS, 
/*  82 */             this.WATER, 
/*  83 */             this.DECOR
/*     */           }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     this.MAINS = new ArrayList((Object[])new RoomCategoryMain[] {
/*  91 */           this.MAIN_AGRIULTURE, 
/*  92 */           this.MAIN_INDUSTRY, 
/*  93 */           this.MAIN_SERVICE, 
/*  94 */           this.MAIN_INFRA });
/*     */   }
/*     */   public final RoomCategorySub WATER; public final RoomCategorySub SER_REL; public final RoomCategorySub SER_CONSUMPTION; public final RoomCategorySub SER_HEALTH; public final RoomCategorySub SER_ENTERTAIN; public final RoomCategorySub SER_DEATH; public final RoomCategorySub SER_HOME;
/*     */   public final LIST<RoomCategorySub> ALL;
/*     */   public final RoomCategoryMain MAIN_AGRIULTURE;
/*     */   public final RoomCategoryMain MAIN_INDUSTRY;
/*     */   public final RoomCategoryMain MAIN_SERVICE;
/*     */   public final RoomCategoryMain MAIN_INFRA;
/*     */   public final ArrayList<RoomCategoryMain> MAINS;
/*     */   
/*     */   public class RoomCategoryMain { public final CharSequence name;
/*     */     public final Icon icon;
/*     */     
/*     */     RoomCategoryMain(CharSequence name, Icon icon, LIST<RoomCategorySub> subs) {
/* 108 */       this.name = name;
/* 109 */       this.icon = icon;
/* 110 */       this.subs = subs;
/* 111 */       this.misc = new RoomCategorySub(RoomCategories.this.all, RoomCategories.¤¤other, (SPRITES.icons()).m.questionmark, COLOR.WHITE100);
/* 112 */       this.misc.main = this;
/* 113 */       for (RoomCategorySub s : subs)
/* 114 */         s.main = this; 
/*     */     }
/*     */     public final RoomCategorySub misc; public final LIST<RoomCategorySub> subs; private LIST<RoomBlueprintImp> all;
/*     */     private void n() {
/* 118 */       LinkedList<RoomBlueprintImp> all = new LinkedList();
/* 119 */       for (RoomCategorySub s : this.subs) {
/* 120 */         for (RoomBlueprintImp p : s.rooms())
/* 121 */           all.add(p); 
/*     */       } 
/* 123 */       for (RoomBlueprintImp p : this.misc.rooms())
/* 124 */         all.add(p); 
/* 125 */       this.all = (LIST<RoomBlueprintImp>)new ArrayList((Iterable)all);
/*     */     }
/*     */ 
/*     */     
/*     */     public LIST<RoomBlueprintImp> all() {
/* 130 */       if (this.all == null) {
/* 131 */         n();
/*     */       }
/* 133 */       return this.all;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\category\RoomCategories.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */