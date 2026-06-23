/*     */ package view.world.ui.region;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ import view.tool.ToolConfig;
/*     */ import view.tool.ToolManager;
/*     */ import world.WORLD;
/*     */ import world.entity.WEntity;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ abstract class PlayToolAttack extends PlacableSimpleTile {
/*  21 */   private static CharSequence ¤¤noSoldiers = "¤Region has no soldiers to attack with.";
/*  22 */   private static CharSequence ¤¤noRange = "¤Can't use garrison to attack outside of the region borders.";
/*  23 */   private static CharSequence ¤¤def = "¤Select an army within your regions' borders to attack.";
/*  24 */   private static CharSequence ¤¤question = "¤Are you sure you wish to declare war on {0} and attack {1} with your garrison?";
/*  25 */   private static CharSequence ¤¤besiged = "¤All exits are blocked. Can only sally out and attack the besieging army."; private Region reg; private final ToolManager tools;
/*     */   
/*     */   static {
/*  28 */     D.ts(PlayToolAttack.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean dismissable;
/*     */   
/*     */   private WArmy aa;
/*     */ 
/*     */   
/*  38 */   private ACTION attack = new ACTION()
/*     */     {
/*     */       public void exe()
/*     */       {
/*  42 */         DIP.WAR().set(PlayToolAttack.this.reg.faction(), PlayToolAttack.this.aa.faction());
/*  43 */         WORLD.BATTLES().regAttack(PlayToolAttack.this.reg, PlayToolAttack.this.aa);
/*     */       }
/*     */     };
/*     */   
/*     */   final ToolConfig config;
/*     */   
/*     */   public PlayToolAttack(ToolManager tools) {
/*  50 */     this(tools, false);
/*     */   }
/*     */   
/*     */   public PlayToolAttack(ToolManager tools, boolean dismissable) {
/*  54 */     super(Dic.¤¤Attack, "");
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
/* 145 */     this.config = new ToolConfig()
/*     */       {
/*     */         public void deactivateAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void update(boolean UIHovered) {
/* 154 */           if (!PlayToolAttack.this.added()) {
/* 155 */             PlayToolAttack.this.tools.place(null, null, false);
/* 156 */           } else if (PlayToolAttack.this.dismissable) {
/* 157 */             WORLD.OVERLAY().hover(PlayToolAttack.this.reg);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean back() {
/* 163 */           return PlayToolAttack.this.dismissable;
/*     */         }
/*     */       };
/*     */     this.tools = tools;
/*     */     this.dismissable = dismissable;
/*     */   }
/*     */   
/*     */   void add(Region reg) {
/*     */     this.reg = reg;
/*     */     this.tools.place((PLACABLE)this, this.config);
/*     */   }
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty) {
/*     */     if ((RD.MILITARY()).garrison.get(this.reg) == 0 || RD.MILITARY().divisions(this.reg).size() == 0)
/*     */       return ¤¤noSoldiers; 
/*     */     WArmy ok = null;
/*     */     CharSequence prob = ¤¤def;
/*     */     for (WArmy a : (WORLD.ENTITIES()).armies.fillTile(tx, ty)) {
/*     */       if (a.faction() != this.reg.faction()) {
/*     */         if (WORLD.BATTLES().besiged(this.reg) && !a.besieging(this.reg)) {
/*     */           prob = ¤¤besiged;
/*     */           continue;
/*     */         } 
/*     */         if (!this.reg.is(a.ctx(), a.cty()) && !a.besieging(this.reg)) {
/*     */           prob = ¤¤noRange;
/*     */           continue;
/*     */         } 
/*     */         ok = a;
/*     */         WORLD.OVERLAY().hoverEntity((WEntity)a);
/*     */         VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.sword);
/*     */       } 
/*     */     } 
/*     */     if (ok == null)
/*     */       return prob; 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public void place(int tx, int ty) {
/*     */     for (WArmy a : (WORLD.ENTITIES()).armies.fillTile(tx, ty)) {
/*     */       if (a.faction() == this.reg.faction() || (WORLD.BATTLES().besiged(this.reg) && !a.besieging(this.reg)))
/*     */         continue; 
/*     */       if (!this.reg.is(a.ctx(), a.cty()) && !a.besieging(this.reg))
/*     */         continue; 
/*     */       if (!DIP.WAR().is(a.faction(), this.reg.faction())) {
/*     */         this.aa = a;
/*     */         Str.TMP.clear().add(¤¤question).insert(0, Faction.name(this.aa.faction())).insert(1, (CharSequence)this.aa.name);
/*     */         (VIEW.inters()).yesNo.activate((CharSequence)Str.TMP, this.attack, ACTION.NOP, this.dismissable);
/*     */         return;
/*     */       } 
/*     */       WORLD.BATTLES().regAttack(this.reg, a);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   abstract boolean added();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayToolAttack.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */