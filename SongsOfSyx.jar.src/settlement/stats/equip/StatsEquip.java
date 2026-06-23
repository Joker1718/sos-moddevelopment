/*     */ package settlement.stats.equip;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.keymap.RMAP;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ public final class StatsEquip
/*     */   extends StatCollection
/*     */ {
/*     */   private final ArrayList<Equip> all;
/*     */   private final ArrayList<EquipBattle> military;
/*     */   private final LIST<EquipBattle> military_all;
/*     */   private final ArrayList<EquipRange> ammo;
/*     */   private final ArrayList<EquipCivic> civic;
/*  34 */   private final ArrayListGrower<EquipBattle.HumanSprite> sprites = new ArrayListGrower();
/*  35 */   public final ArrayListGrower<EquipBattle> mounts = new ArrayListGrower();
/*     */   
/*  37 */   private static CharSequence ¤¤name = "Equipment";
/*  38 */   private static CharSequence ¤¤desc = "Having your subjects equip certain items can boost them in different ways. It can also improve happiness amongst them.";
/*  39 */   static CharSequence ¤¤Level = "¤{0} Level";
/*  40 */   static CharSequence ¤¤Target = "¤{0} Target";
/*  41 */   static CharSequence ¤¤Level_desc = "¤The target number of items each individual should equip.";
/*  42 */   public static CharSequence ¤¤Wear = "¤Wear-out rate per item and year:";
/*     */   
/*     */   public final Equip CLOTHES;
/*     */   public final RMAP<EquipBattle> militaryColl;
/*     */   public final RMAP<Equip> collAll;
/*     */   
/*     */   static {
/*  49 */     D.ts(StatsEquip.class);
/*     */   }
/*     */   
/*     */   public StatsEquip(StatsInit init) throws IOException {
/*  53 */     super(init, "EQUIP", ¤¤name, ¤¤desc);
/*     */     
/*  55 */     final LinkedList<Equip> all = new LinkedList();
/*     */     
/*  57 */     PATH data = init.pd.getFolder("equip");
/*     */ 
/*     */     
/*  60 */     LinkedList<EquipCivic> tmp = new LinkedList();
/*  61 */     PATH d = data.getFolder("civic");
/*  62 */     this.CLOTHES = new EquipCivic("_CLOTHES", d, (LISTE<Equip>)all, (LISTE<EquipCivic>)tmp, init); byte b1; int i; String[] arrayOfString1;
/*  63 */     for (i = (arrayOfString1 = d.getFiles()).length, b1 = 0; b1 < i; ) { String k = arrayOfString1[b1]; b1++; }
/*     */ 
/*     */     
/*  66 */     this.civic = new ArrayList((Iterable)tmp);
/*     */ 
/*     */     
/*  69 */     LinkedList<EquipBattle> mil = new LinkedList();
/*  70 */     KeyMap<TILE_SHEET> sprite = new KeyMap();
/*     */     
/*  72 */     LinkedList<EquipBattle> linkedList1 = new LinkedList();
/*  73 */     PATH pATH1 = data.getFolder("battle"); byte b2; int j; String[] arrayOfString2;
/*  74 */     for (j = (arrayOfString2 = pATH1.getFiles()).length, b2 = 0; b2 < j; ) { String k = arrayOfString2[b2];
/*     */       
/*  76 */       EquipBattle e = new EquipBattle("BATTLE", k, pATH1, (LISTE<Equip>)all, (LISTE<EquipBattle>)mil, init, sprite);
/*  77 */       linkedList1.add(e); b2++; }
/*     */     
/*  79 */     this.military = new ArrayList((Iterable)linkedList1);
/*     */ 
/*     */ 
/*     */     
/*  83 */     LinkedList<EquipRange> linkedList = new LinkedList();
/*  84 */     pATH1 = data.getFolder("ranged");
/*  85 */     for (j = (arrayOfString2 = pATH1.getFiles()).length, b2 = 0; b2 < j; ) { String k = arrayOfString2[b2]; b2++; }
/*     */ 
/*     */     
/*  88 */     this.ammo = new ArrayList((Iterable)linkedList);
/*     */ 
/*     */     
/*  91 */     this.military_all = (LIST<EquipBattle>)new ArrayList((Iterable)mil);
/*  92 */     KeyMap<EquipBattle> map = new KeyMap();
/*  93 */     for (EquipBattle mm : this.military_all) {
/*  94 */       map.put(mm.eKey(), mm);
/*     */     }
/*  96 */     this.militaryColl = new RMAP("EQUIPMENT", this.military_all);
/*     */     
/*  98 */     this.all = new ArrayList((Iterable)all);
/*     */     
/* 100 */     this.collAll = new RMAP("EQUIPMENT", (LIST)this.all);
/*     */     
/* 102 */     D.t(this);
/*     */     
/* 104 */     init.updatable.add(new StatsInit.StatUpdatableI()
/*     */         {
/*     */           public void update16(Humanoid h, int updateR, boolean day, int updateI)
/*     */           {
/* 108 */             for (Equip t : all) {
/* 109 */               t.update16(h, updateI, updateI, day);
/*     */             }
/*     */           }
/*     */         });
/*     */     
/* 114 */     init.onArrival.add(new StatsInit.StatInitable()
/*     */         {
/*     */           public void init(Induvidual h)
/*     */           {
/* 118 */             for (Equip t : all) {
/* 119 */               t.set(h, t.arrivalAmount);
/*     */             }
/*     */           }
/*     */         });
/*     */     
/* 124 */     for (EquipBattle e : this.military_all) {
/* 125 */       if (e.sprite != null) {
/* 126 */         this.sprites.add(e.sprite);
/*     */       }
/*     */     } 
/* 129 */     for (EquipBattle e : this.military_all) {
/* 130 */       if (e.mount != null) {
/* 131 */         this.mounts.add(e);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drop(Humanoid h) {
/* 138 */     for (Equip e : this.all) {
/* 139 */       int a = Math.round(e.stat().indu().get(h.indu()) * RND.rFloat());
/* 140 */       if (a > 0) {
/* 141 */         (SETT.THINGS()).resources.create(h.physics.tileC(), e.resource(), a);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public LIST<Equip> allE() {
/* 147 */     return (LIST<Equip>)this.all;
/*     */   }
/*     */   
/*     */   public LIST<EquipCivic> civics() {
/* 151 */     return (LIST<EquipCivic>)this.civic;
/*     */   }
/*     */   
/*     */   public LIST<EquipBattle> BATTLE_MELEE() {
/* 155 */     return (LIST<EquipBattle>)this.military;
/*     */   }
/*     */   
/*     */   public LIST<EquipRange> RANGED() {
/* 159 */     return (LIST<EquipRange>)this.ammo;
/*     */   }
/*     */   
/*     */   public LIST<EquipBattle> BATTLE_ALL() {
/* 163 */     return this.military_all;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch shadow, double forward, int x, int y) {
/* 168 */     for (EquipBattle.HumanSprite s : this.sprites)
/* 169 */       s.render(a, (SPRITE_RENDERER)r, dir, forward, x, y, shadow); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\equip\StatsEquip.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */