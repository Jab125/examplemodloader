package com.jab125.loader.transformer;

import com.jab125.tweakloader.transformer.ClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

public class StupidMobEntityFixer implements ClassTransformer {
    @Override
    public boolean shouldTransform(String name) {
        return "net.minecraft.entity.LivingEntity".equals(name);
    }

    @Override
    public byte[] transformClass(String className, byte[] in) {
        ClassReader classReader = new ClassReader(in);
        ClassNode node = new ClassNode(Opcodes.ASM9);
        classReader.accept(node, ClassReader.SKIP_DEBUG + ClassReader.SKIP_FRAMES);
        var g = node.methods.stream().filter(a -> "getAttackPos".equals(a.name)).findFirst();
        if (g.isPresent()) {
            g.get().access -= Opcodes.ACC_PROTECTED;
            g.get().access += Opcodes.ACC_PUBLIC;
        }
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
        node.accept(classWriter);
        return classWriter.toByteArray();
    }
}
